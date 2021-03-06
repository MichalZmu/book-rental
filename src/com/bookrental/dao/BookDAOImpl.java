package com.bookrental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Book> books = currentSession.createQuery("from Book").list();
		
		return books;		
	}

	@Override
	public void saveBook(Book theBook) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theBook);
			
	}

	@Override
	public Book getBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Book theBook = currentSession.get(Book.class, theId);
		
		return theBook;
	}

	@Override
	public void rentBook(Book theBook, Client theClient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		theBook.setClient(theClient);
		
		currentSession.update(theBook);
		
	}

	@Override
	public void deleteBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query myQuery = currentSession.createQuery("delete from Book where idBook= :bookId");
		
		myQuery.setParameter("bookId", theId);
		
		myQuery.executeUpdate();
		
	}

	@Override
	public void updateBook(Book theBook) {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		currentSession.update(theBook);
		
	}
	
	@Override
	public void updateBook(int idBook, String author, String title, String genre, String rentalDate, String returnDate) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Book book = currentSession.get(Book.class, idBook);
				
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		book.setRentalDate(rentalDate);
		book.setReturnDate(returnDate);
		
		currentSession.update(book);
		
	}
	
	@Override
	public void returnBook(int theId) {
	        
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Query myQuery = currentSession.createQuery("update Book set returnDate=null, rentalDate=null, client=null where idBook= :bookId");
		myQuery.setParameter("bookId", theId);
		myQuery.executeUpdate();
	        
	 }
	
	@Override
	public boolean checkIfRented(int theId) {
	        
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query myQuery = currentSession.createQuery("select idBook from Book where client= :clinetId");
		myQuery.setParameter("clinetId", theId);
		
		List<Object[]> resultList = myQuery.getResultList();
		
		if(resultList.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
		
	        
	 }

}
