package com.bookrental.service;

import java.util.List;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

public interface BookAndClientService {
	
	public List<Book> getBooks();
	public List<Client> getClients();
	
	public void saveBook(Book theBook);
	public void saveClient(Client theClient);
	
	public void updateBook(Book theBook);
	public void updateBook(int idBook, String author, String title, String genre, String rentalDate, String returnDate);

	public Book getBook(int theId);
	public Client getClient(int theId);

	public void deleteBook(int theId);
	
	public void rentBook(Book theBook, Client theClient);
	
	public void returnBook(int theId);
	void deleteClient(int theId);
	boolean checkIfUserHasBook(int theId);
}
