package co.saimyr.bookstore.domain.repository;

import java.util.List;

import co.saimyr.bookstore.persistence.entity.BookEntity;

public interface BookRepository {
	List<BookEntity> findAll();
	List<BookEntity> findByAuthor(String author);
	List<BookEntity> findByPublisher(String publisher);
	BookEntity save(BookEntity b);
	void delete(BookEntity b);
}
