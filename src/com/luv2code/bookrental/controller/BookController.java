package com.luv2code.bookrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.bookrental.entity.Book;
import com.luv2code.bookrental.entity.Client;
import com.luv2code.bookrental.service.BookAndClientService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookAndClientService bookService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "home-page";
	}
	
	@GetMapping("/list-books")
	public String listBooks(Model theModel) {
		
		List<Book> theBooks = bookService.getBooks();
		
		theModel.addAttribute("books", theBooks);
		
		return "list-books";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "book-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors())
		{
			return "book-form"; 
		}
		else {
			bookService.saveBook(theBook);
			return "redirect:/book/list-books";
		}
				
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute("book") Book theBook) {
		
		bookService.updateBook(theBook.getIdBook(), theBook.getAuthor(), theBook.getTitle(), theBook.getGenre(), theBook.getRentalDate(), theBook.getReturnDate());
		
		return "redirect:/book/list-books";
	}
	
	
		
	@PostMapping("/rentBook")
	public String rentBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult, @ModelAttribute("client") Client theClient) {

		if(theBindingResult.hasErrors())
		{
			return "rent-form2"; 
		}
		else {
			bookService.rentBook(theBook, theClient);
			return "redirect:/book/list-books";
		}
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
		
		Book theBook = bookService.getBook(theId);
		
		theModel.addAttribute("book", theBook);
		
		return "book-form-update";
	}
	
	@RequestMapping("/showFormForRent")
	public String showFormForRent(@RequestParam("bookId") int theId, Model theModel) {
		
		List<Client> theClients = bookService.getClients();
		
		theModel.addAttribute("client", theClients);
		
		Book theBook = bookService.getBook(theId);
		
		theModel.addAttribute("book", theBook);

		
		return "rent-form";
	}
	
	@RequestMapping("/showFormForRent2")
	public String showFormForRent2(@RequestParam("clientId") int theClientId, @RequestParam("bookId") int theBookId, Model theModel) {
		
		Client theClient = bookService.getClient(theClientId);
		
		theModel.addAttribute("client", theClient);
		
		Book theBook = bookService.getBook(theBookId);
		
		theModel.addAttribute("book", theBook);		
				
		return "rent-form2";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int theId) {
		
		bookService.deleteBook(theId);
		
		return "redirect:/book/list-books";
	}
	
	@GetMapping("/returnBook")
	public String returnBook(@RequestParam("bookId") int theId) {
		
		bookService.returnBook(theId);
		
		return "redirect:/book/list-books";
	}	
	
}
