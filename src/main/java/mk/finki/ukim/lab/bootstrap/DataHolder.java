package mk.finki.ukim.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.lab.repository.jpa.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>(10);
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){


        if(bookRepository.findAll().isEmpty()){
            books.add(new Book("The Great Gatsby", "Classic", 4.2));
            books.add(new Book("To Kill a Mockingbird", "Classic", 4.5));
            books.add(new Book("Dune",  "Fiction", 4.3));
            books.add(new Book("The Hobbit", "Fantasy", 4.7));
            books.add(new Book("The Shining", "Horror", 4.1));
            books.add(new Book("Pride and Prejudice", "Romance", 4.4));
            books.add(new Book("The Da Vinci Code", "Mystery", 3.9));
            books.add(new Book("The Hunger Games", "Young Adult", 4.2));
            books.add(new Book("Gone Girl", "Thriller", 4.0));
            books.add(new Book("The Martian", "Science Fiction", 4.5));
            bookRepository.saveAll(books);
        }

    }
}
