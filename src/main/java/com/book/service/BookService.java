package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.modal.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	// Save Book
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	// Find all book
	public List<Book> findAllBook() {
		return bookRepo.findAll();
	}

	// Find book by ID
	public Optional<Book> findBookById(long bookId) {
		return bookRepo.findById(bookId);
	}

	// Update Book
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}

	// Delete Book
	public String deleteBook(long bookId) {
		bookRepo.deleteById(bookId);
		return "Book with Id = " + bookId + " is successfully deleted";
	}
}
