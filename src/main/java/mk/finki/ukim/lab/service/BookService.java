package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, double rating);

    Book findBook(Long id);
    Book add(String title, String genre, Double averageRating, Long authorId);
    Book update(Long id, String title, String genre, Double averageRating, Long authorId);
    void delete(Long id);

}
