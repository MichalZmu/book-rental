package com.bookrental.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookrental.dao.BookDAO;
import com.bookrental.dao.ClientDAO;
import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

@Service
public class BookAndClientServiceImpl implements BookAndClientService {

	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookDAO.getBooks();
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		bookDAO.saveBook(theBook);
		
	}

	@Override
	@Transactional
	public Book getBook(int theId) {
		
		return bookDAO.getBook(theId);
	}

	@Override
	@Transactional
	public List<Client> getClients() {

		return clientDAO.getClients();
	}

	@Override
	@Transactional
	public Client getClient(int theId) {
		
		return clientDAO.getClient(theId);
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		
		clientDAO.saveClient(theClient);
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {
		
		bookDAO.deleteBook(theId);
		
	}
	
	@Override
	@Transactional
	public void deleteClient(int theId) {
		
		clientDAO.deleteClient(theId);
		
	}

	@Override
	@Transactional
	public void rentBook(Book theBook, Client theClinet) {
		
		bookDAO.rentBook(theBook, theClinet);
		
	}

	@Override
	@Transactional
	public void updateBook(Book theBook) {

		bookDAO.updateBook(theBook);
	}
	
	@Override
	@Transactional
	public void updateBook(int idBook, String author, String title, String genre, String rentalDate, String returnDate) {
		
		bookDAO.updateBook(idBook, author, title, genre, rentalDate, returnDate);
	}

	@Override
	@Transactional
	public void returnBook(int theId) {
		
		bookDAO.returnBook(theId);
	}
	
	
}
