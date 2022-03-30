package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.exception.RequestException;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.saimyr.bookstore.domain.service.BookService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookEntity>> getAll() {
		List<BookEntity> bookEntities = bookService.getAll();
		if (bookEntities.isEmpty() || bookEntities == null){
			throw new RequestException(HttpStatus.NOT_FOUND,"Lista vacia");
		}
		return new ResponseEntity<>(bookEntities,HttpStatus.OK);
	}

	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookEntity>> getByAuthor(@PathVariable("author") String author) {
		return new ResponseEntity<>(bookService.getAllByAuthor(author), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookEntity> newBook(@RequestBody BookEntity bookEntity) {
		return new ResponseEntity<>(bookService.newBook(bookEntity),HttpStatus.CREATED);
	}
}
