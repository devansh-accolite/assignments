package com.au.library.model;

public class Book {
	private int id;
	private String bookName;
	private String authorName;
	private int price;
	private String description;
	
	public Book() {
		
	}
	
	public Book(int id, String bookName, String authorName, int price, String description) {
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
