package mk.finki.ukim.lab.repository;

import mk.finki.ukim.lab.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
