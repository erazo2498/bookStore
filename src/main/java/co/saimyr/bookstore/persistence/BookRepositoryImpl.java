package co.saimyr.bookstore.persistence;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookDto;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.crud.CrudBookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private CrudBookRepository h2BookRepo;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<BookDto> findAll() {
		return bookMapper.toBooksDto(h2BookRepo.findByOrderByNameAsc());
	}
	
	@Override
	public List<BookDto> findByAuthor(String author) {
		return bookMapper.toBooksDto(h2BookRepo.findByAuthor(author));
	}

	@Override
	public List<BookDto> findByPublisher(String publisher) {
		return bookMapper.toBooksDto(h2BookRepo.findByPublisher(publisher));
	}

	@Override
	public BookDto save(BookDto b) {
		return bookMapper.toBookDto(h2BookRepo.save(bookMapper.toBookEntity(b)));
	}

	@Override
	public void delete(int isbn) {

	}
	@Override
	public Optional<BookDto> findByIsbn(int isbn){
		return h2BookRepo.findById(isbn).map(bookEntity -> bookMapper.toBookDto(bookEntity));
	}
}
