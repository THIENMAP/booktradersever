package phuocthien.com.bookstrade_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phuocthien.com.bookstrade_springboot.model.Book;
import phuocthien.com.bookstrade_springboot.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBookById(id);

        if (book.isPresent()) {
            return ResponseEntity.ok().body(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{categoryId}")
    public List<Book> getBooksByCategoryId(@PathVariable("categoryId") int categoryId) {
        return bookService.getBooksByCategoryId(categoryId);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByName(@RequestParam("name") String name) {
        return bookService.searchBooksByName(name);
    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        bookService.saveOrUpdateBook(book);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        Optional<Book> existingBook = bookService.getBookById(id);

        if (existingBook.isPresent()) {
            existingBook.get().setCategoriId(book.getCategoriId());
            existingBook.get().setName(book.getName());
            existingBook.get().setPrice(book.getPrice());
            existingBook.get().setImage(book.getImage());
            existingBook.get().setQuantity(book.getQuantity());
            existingBook.get().setAuthor(book.getAuthor());
            existingBook.get().setPublishingYear(book.getPublishingYear());
            existingBook.get().setText(book.getText());

            bookService.saveOrUpdateBook(existingBook.get());

            return ResponseEntity.ok().body(existingBook.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        Optional<Book> existingBook = bookService.getBookById(id);

        if (existingBook.isPresent()) {
            bookService.deleteBook(id);
            return ResponseEntity.ok().body("Book has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
