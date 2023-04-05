package phuocthien.com.bookstrade_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuocthien.com.bookstrade_springboot.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Override
    List<Book> findAll();

    List<Book> findAllById(int id);
}
