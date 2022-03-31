package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookDto;
import co.saimyr.bookstore.domain.exception.BadRequestException;
import co.saimyr.bookstore.domain.exception.NotFoundException;
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

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookDto>> getAll() {
		return new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
	}

	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookDto>> getByAuthor(@PathVariable("author") String author) {
		return new ResponseEntity<>(bookService.getAllByAuthor(author), HttpStatus.OK);
	}
	@GetMapping(value = "/publisher/{publisher}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookDto>> getByPublisher(@PathVariable("publisher") String publisher) {
		return new ResponseEntity<>(bookService.getAllByPublisher(publisher), HttpStatus.OK);
	}

	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookDto> newBook(@RequestBody BookDto bookDto) {
		return new ResponseEntity<>(bookService.newBook(bookDto),HttpStatus.CREATED);
	}
}
