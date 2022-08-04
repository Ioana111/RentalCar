package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.javaremote37.springseed.dto.BookDto;
import ro.sda.javaremote37.springseed.entities.Book;
import ro.sda.javaremote37.springseed.exceptions.EntityNotFoundError;
import ro.sda.javaremote37.springseed.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public void createBook(BookDto form) {
        Book book = bookMapper.convertToEntity(form);
        bookRepository.save(book);
    }

    public BookDto findById(long id) {
        Book entityBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        return bookMapper.convertToDto(entityBook);
    }

    public void deleteById(long id) {
        bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        bookRepository.deleteById(id);
    }
}
