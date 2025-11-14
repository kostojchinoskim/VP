package mk.finki.ukim.lab.repository.impl;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryBookRepository  implements BookRepository {

    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(text.toLowerCase()) &&
                        book.getAverageRating() >= rating)
                .collect(Collectors.toList());
    }

    @Override
    public Book findBook(Long id) {
        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Book add(String title, String genre, Double averageRating, Author author) {
        Book book = new Book(title, genre, averageRating, author);
        book.setAuthor(author);
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public Book update(Long id, String title, String genre, Double averageRating, Author author) {
        int idx = IntStream.range(0, DataHolder.books.size())
                .filter(i -> DataHolder.books.get(i).getId().equals(id))
                .findFirst()
                .orElse(-1);

        if(idx == -1)
            return null;

        Book book = new Book(title, genre, averageRating, author);
        book.setAuthor(author);
        DataHolder.books.set(idx, book);
        return book;
    }

    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
    }
}
