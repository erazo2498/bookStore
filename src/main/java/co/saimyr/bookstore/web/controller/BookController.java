package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.saimyr.bookstore.domain.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookEntity> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookEntity> getByAuthor(@PathVariable("author") String author) {
		return bookService.getAllByAuthor(author);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BookEntity newBook(@RequestBody BookEntity b) {
		return bookService.newBook(b);
	}
}
