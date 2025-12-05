package mk.finki.ukim.lab.repository.mock;

import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;

import java.util.List;

public interface InMemoryBookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    List<Book> findAllByAuthor_Id(Long authorId);

    Book findBook(Long id);
    Book add(String title, String genre, Double averageRating, Author author);
    Book update(Long id, String title, String genre, Double averageRating, Author author);
    void delete(Long id);
}