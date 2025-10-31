package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.models.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, double rating);
}
