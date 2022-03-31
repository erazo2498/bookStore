package co.saimyr.bookstore.domain.repository;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookDto;

public interface BookRepository {
	List<BookDto> findAll();
	List<BookDto> findByAuthor(String author);
	List<BookDto> findByPublisher(String publisher);
	Optional<BookDto> findByIsbn(int isbn);
	BookDto save(BookDto b);
	void delete(int isbn);
}
