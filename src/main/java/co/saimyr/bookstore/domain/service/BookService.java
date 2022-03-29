package co.saimyr.bookstore.domain.service;

import java.util.List;

import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<BookEntity> getAll() {
		return bookRepository.findAll();
	}
	public List<BookEntity> getAllByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}
	public BookEntity newBook(BookEntity b) {
		return bookRepository.save(b);
	}
}
