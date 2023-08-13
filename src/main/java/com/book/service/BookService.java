package com.book.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.modal.Book;
import com.book.repository.BookRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public Book saveBook(@Valid Book book) {
		return bookRepo.save(book);
	}

	public List<Book> findAllBook() {
		return bookRepo.findAll();
	}

	//Optional class ka upyog null values ke sath deal karne ke liye hota hai.
	//Null Safety: Agar bookId ke koi book nahi milti hai, to Optional.empty() return hoti hai. Isse null 
	//pointer exception ki problem nahi hoti. Aap isPresent() method se check kar sakte hain ki koi value 
	// mili hai ya nahi.
	public Optional<Book> findBookById(@Min(1) long bookId) {
		return bookRepo.findById(bookId);
	}

	// Jab aap @Valid annotation use karte hain, to Hibernate Validator us validation rules ko apply karta
	// hai jo aapne apne model (entity) classes par annotations ke madhyam se define kiye hote hain.
	public Book editBook(@Valid Book book) throws IllegalAccessException {
		Long id = book.getId();
		if (!bookRepo.existsById(id)) {
			throw new IllegalAccessException("Book with ID " + id + " not found");
		}
		return bookRepo.save(book);
	}

	// @Min(1): This annotation specifies that the annotated element must be a numeric value greater than 
	// or equal to 1. It's applied to the bookId parameter in the findBookById and deleteBook methods.
	public String deleteBook(@Min(1) long bookId) throws IllegalAccessException {
		if (!bookRepo.existsById(bookId)) {
			throw new IllegalAccessException("Book with ID " + bookId + " not found");
		}
		bookRepo.deleteById(bookId);
		return "Book with Id = " + bookId + " is successfully deleted";
	}
}
