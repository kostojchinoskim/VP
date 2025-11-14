package mk.finki.ukim.lab.repository;

import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);

    Book findBook(Long id);
    Book add(String title, String genre, Double averageRating, Author author);
    Book update(Long id, String title, String genre, Double averageRating, Author author);
    void delete(Long id);
}
