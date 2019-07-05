package com.bookrental.dao;

import java.util.List;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

public interface BookDAO {
	
	List<Book> getBooks();
	
	void saveBook(Book theBook);
	
	void updateBook(Book theBook);
	void updateBook(int idBook, String author, String title, String genre, String rentalDate, String returnDate);
	
	Book getBook(int theId);
	
	void rentBook(Book theBook, Client theClient);
	
	void deleteBook(int theId);

	void returnBook(int theId);

	boolean checkIfRented(int theId);
	
}
