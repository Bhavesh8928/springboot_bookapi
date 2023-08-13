package com.book.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.book.modal.Book;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String home() {
		return "This is Book Shop API";
	}

	@PostMapping("/books")
	public Book saveBook(@RequestBody Book bookDetails) {
		return bookService.saveBook(bookDetails);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAllBook();
	}

	@GetMapping("/books/{bookId}")
	public Optional<Book> getBookById(@PathVariable long bookId) {
		return bookService.findBookById(bookId);
	}

	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) throws IllegalAccessException {
		return bookService.editBook(book);
	}

	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable long bookId) throws IllegalAccessException {
		return bookService.deleteBook(bookId);
	}
}
