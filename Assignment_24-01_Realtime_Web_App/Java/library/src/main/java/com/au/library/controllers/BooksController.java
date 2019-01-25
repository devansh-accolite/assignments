package com.au.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.library.model.Book;
import com.au.library.repository.BooksDAO;

@RestController
public class BooksController {
	@Autowired
	BooksDAO bookDao;
	
	@GetMapping(value="/books", produces="application/json")
	public List<Book> getAll() {
		return bookDao.getAll();
	}
	
	@GetMapping(value="/books/{bookId}/get")
	public Book getBookById(@PathVariable(value="bookId") int bookId) {
		return bookDao.getBookById(bookId);
	}
	
	@PostMapping(value="/books")
	public Book createBook(@RequestBody Book book) {
		return bookDao.createBook(book);
	}

	@GetMapping(value="/books/{bookId}/remove")
	public int removeBook(@PathVariable(value="bookId") int bookId) {
		return bookDao.removeBook(bookId);
	}
	
	@GetMapping(value="/cart/get", produces="application/json")
	public List<Book> getBooksFromCart() {
		return bookDao.getBooksFromCart();
	}
	
	@PostMapping(value="/cart")
	public int addBookToCart(@RequestBody Book book) {
		return bookDao.addBookToCart(book.getId());
	}
	
	@GetMapping(value="/cart/{bookId}/remove")
	public int removeBookFromCart(@PathVariable(value="bookId") int bookId) {
		return bookDao.removeBookFromCart(bookId);
	}
	
	@GetMapping(value="/cart/remove")
	public int removeAllBooks() {
		return bookDao.removeAllBooks();
	}
}
