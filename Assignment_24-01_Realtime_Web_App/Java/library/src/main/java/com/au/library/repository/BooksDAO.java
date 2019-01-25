package com.au.library.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.library.model.Book;

@Repository
public class BooksDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Book> getAll() {
		return jdbcTemplate.query("select * from book", (rs, i) -> {
			return new Book(rs.getInt("id"), 
					rs.getString("title"), 
					rs.getString("author"), 
					rs.getInt("price"), 
					rs.getString("description"));
		});
	}
	
	public Book getBookById(int id) {
		List<Book> bookList = jdbcTemplate.query("select * from book where id = " + id, (rs, i) -> {
			return new Book(rs.getInt("id"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getInt("price"),
					rs.getString("description"));
		});
		if(!bookList.isEmpty()) {
			return bookList.get(0);
		} else {
			return null;
		}
	}
	
	public Book createBook(Book book) {
		jdbcTemplate.update("insert into book values (?, ?, ?, ?, ?);", book.getId(), book.getDescription(), book.getBookName(), book.getAuthorName(), book.getPrice());
		return book;
	}

	public int removeBook(int id) {
		return jdbcTemplate.update("delete from book where id = " + id + ";");
	}
	
	public List<Book> getBooksFromCart() {
		List<Book> bookList = new ArrayList<Book>();
		
		List<Integer> idList = jdbcTemplate.query("select * from cart",  (rs, i) -> {
			return rs.getInt("id");
		});
		for(Integer i: idList) {
			bookList.add(getBookById(i));
		}
		
		return bookList;
	}
	
	public int addBookToCart(int id) {
		jdbcTemplate.update("insert into cart values (?);", id);
		return id;
	}

	public int removeBookFromCart(int id) {
		return jdbcTemplate.update("delete from cart where id = " + id + ";");
	}

	public int removeAllBooks() {
		return jdbcTemplate.update("delete from cart;");
	}
}
