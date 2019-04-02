package com.bookrental.entity;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Book")
@org.hibernate.annotations.Entity(dynamicUpdate = true, selectBeforeUpdate = true)
public class Book {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="title")
	private String title;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="author")
	private String author;
	
	@Column(name="genre")
	private String genre;
	
	@Pattern(regexp="^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message="wrong date format")
	@Column(name="rental_date")
	private String rentalDate;
	
	@Pattern(regexp="^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message="wrong date format")
	@Column(name="return_date")
	private String returnDate;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;

	public Book() {
		
	}
	
		
	
	public Book(String bookTitle, String author, String genre, String rentalDate, String returnDate) {
		super();
		this.title = bookTitle;
		this.author = author;
		this.genre = genre;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}



	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int id) {
		this.idBook = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		System.out.println("Wywoluje metode Client client");
		this.client = client;
	}
	
	public void setClient(String objectInString) {
		System.out.println("Wywoluje metode String objectInString");

		String[] splited = objectInString.split("\\s+");
		Client client = new Client(splited[0], splited[1], splited[2]);
		this.client = client;
	}

	@Override
	public String toString() {
		return "Book [id=" + idBook + ", title=" + title + ", author=" + author + ", genre=" + genre + ", rentalDate="
				+ rentalDate + ", returnDate=" + returnDate + ", client=" + client + "]";
	}

	

}
