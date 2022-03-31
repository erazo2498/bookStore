package co.saimyr.bookstore.domain.service;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookDto;
import co.saimyr.bookstore.domain.exception.BadRequestException;
import co.saimyr.bookstore.domain.exception.NotFoundException;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.domain.repository.BookRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<BookDto> getAll() {
		List<BookDto> bookDtoList = bookRepository.findAll();
		if (bookDtoList == null || bookDtoList.isEmpty()){
			throw new NotFoundException("The requested books do not exist");
		}
		return bookDtoList;
	}
	public List<BookDto> getAllByAuthor(String author) {
		List<BookDto> bookDtoList = bookRepository.findByAuthor(author);
		if (bookDtoList == null || bookDtoList.isEmpty()){
			throw new NotFoundException("The requested books with author "+ author + " do not exist");
		}
		return bookDtoList;
	}
	public List<BookDto> getAllByPublisher(String publisher){
		List<BookDto> bookDtoList = bookRepository.findByPublisher(publisher);
		if (bookDtoList == null || bookDtoList.isEmpty()){
			throw new NotFoundException("The requested books with publisher "+ publisher + " do not exist");
		}
		return bookDtoList;
	}
	public BookDto newBook(BookDto bookDto) {
		if (bookDto.getName()==null || bookDto.getName().isEmpty()){
			throw new BadRequestException("Invalid name");
		}else if (bookDto.getAuthor()==null || bookDto.getAuthor().isEmpty()){
			throw new BadRequestException("Invalid author");
		}else if (bookDto.getPublisher()==null || bookDto.getPublisher().isEmpty()){
			bookDto.setPublisher("no publisher");
		}
		return bookRepository.save(bookDto);
	}
	public void deleteBook(int isbn){bookRepository.delete(isbn);}
}
