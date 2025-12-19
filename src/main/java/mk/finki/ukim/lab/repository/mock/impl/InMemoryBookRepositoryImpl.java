package mk.finki.ukim.lab.repository.mock.impl;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.repository.mock.InMemoryBookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryBookRepositoryImpl implements InMemoryBookRepository {

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
    public List<Book> findAllByAuthor_Id(Long authorId) {
        return DataHolder.books.stream()
                .filter(book -> book.getAuthor() != null && book.getAuthor().getId().equals(authorId))
                .toList();
    }

    @Override
    public Book findBook(Long id) {
        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Book add(String title, String genre, Double averageRating, Author author) {
        Book book = new Book(title, genre, averageRating);
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

        Book book = new Book(title, genre, averageRating);
        book.setAuthor(author);
        DataHolder.books.set(idx, book);
        return book;
    }


//    @Override
//    public Book add(String title, String genre, Double averageRating, Author author){
//
//        Book book = new Book(title, genre, averageRating, author);
//        book.setId(DataHolder.bookIdCounter++);
//        book.setAuthor(author);
//
//        DataHolder.books.add(book);
//        return book;
//    }
//
//    @Override
//    public Book update(Long id, String title, String genre, Double averageRating, Author author) {
//
//        Book book = findBook(id);
//        if (book == null) return null;
//
//        book.setTitle(title);
//        book.setGenre(genre);
//        book.setAverageRating(averageRating);
//        book.setAuthor(author);
//
//        return book;
//    }


    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
    }
}
