package com.luv2code.bookrental.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.bookrental.entity.Book;
import com.luv2code.bookrental.entity.Client;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);
		List<Book> books = (List<Book>) currentSession.createQuery("from Book").list();

		//List<Book> books = theQuery.getResultList();
		
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
		
		//Book theBook = currentSession.get(Book.class, theBookId);
		//Client theClient = currentSession.get(Client.class, theClientId);
		
		System.out.println("this is book in DAO: " + theBook);
		System.out.println("this is client in DAO: " + theClient);
		
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
		
		System.out.println("Starting updating...");
		System.out.println("This is theBook in DAO: " + theBook);
		
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
		
		//Book theBook = currentSession.get(Book.class, theId);
		//theBook.setRentalDate(null);
		//theBook.setReturnDate(null);
		//theBook.setClient(null);
		
		Query myQuery = currentSession.createQuery("update Book set returnDate=null, rentalDate=null, client=null where idBook= :bookId");
		myQuery.setParameter("bookId", theId);
		myQuery.executeUpdate();
	        
	 }

}
