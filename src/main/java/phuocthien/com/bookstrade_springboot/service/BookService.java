package phuocthien.com.bookstrade_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phuocthien.com.bookstrade_springboot.model.Book;
import phuocthien.com.bookstrade_springboot.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByCategoryId(int categoryId) {
        return bookRepository.findByCategoriId(categoryId);
    }

    public List<Book> searchBooksByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }

    public void saveOrUpdateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


}
