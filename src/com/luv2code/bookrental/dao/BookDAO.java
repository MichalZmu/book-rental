package com.luv2code.bookrental.dao;

import java.time.LocalDate;
import java.util.List;

import com.luv2code.bookrental.entity.Book;
import com.luv2code.bookrental.entity.Client;

public interface BookDAO {
	
	public List<Book> getBooks();
	
	public void saveBook(Book theBook);
	
	public void updateBook(Book theBook);
	public void updateBook(int idBook, String author, String title, String genre, String rentalDate, String returnDate);
	
	public Book getBook(int theId);
	
	public void rentBook(Book theBook, Client theClient);
	
	public void deleteBook(int theId);

	void returnBook(int theId);
	
}
