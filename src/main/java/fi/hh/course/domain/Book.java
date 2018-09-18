package fi.hh.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

@Entity
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	@Size(min=5, max=30)
	private String title;
	
	@Size(min=5, max=30)
	private String author;

	@Digits(integer=4, fraction=0)
	private int year; 
	
	@Size(min=5, max=30)
	private String isbn;
	
	@NotNull
	private Double price;
	
	@ManyToOne 
	@JsonIgnore
	@JoinColumn(name = "categoryid") 
	private Category category;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, int year, String isbn, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public Long getId () {
		return this.id;
	}
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return this.category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + ", category=" + category + "]";
	}
	
	
}
