package mk.finki.ukim.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.models.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>(10);
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init(){

        authors.add(new Author("F. Scott", "Fitzgerald","United States","/"));
        authors.add(new Author("Harper", "Lee","United States","/"));
        authors.add(new Author("Frank", "Herbert","United States","/"));
        authors.add(new Author("J.R.R.", "Tolkien","United Kingdom","/"));
        authors.add(new Author("Stephen", "King","United States","/"));
        authors.add(new Author("Jane", "Austen","United Kingdom","/"));
        authors.add(new Author("Dan", "Brown","United States","/"));
        authors.add(new Author("Suzanne", "Collins","United States","/"));
        authors.add(new Author("Gillian", "Flynn","United States","/"));
        authors.add(new Author("Andy", "Weir","United States","/"));

        books.add(new Book("The Great Gatsby", "Classic", 4.2, authors.get(0)));
        books.add(new Book("To Kill a Mockingbird", "Classic", 4.5, authors.get(1)));
        books.add(new Book("Dune",  "Fiction", 4.3, authors.get(2)));
        books.add(new Book("The Hobbit", "Fantasy", 4.7, authors.get(3)));
        books.add(new Book("The Shining", "Horror", 4.1, authors.get(4)));
        books.add(new Book("Pride and Prejudice", "Romance", 4.4, authors.get(5)));
        books.add(new Book("The Da Vinci Code", "Mystery", 3.9, authors.get(6)));
        books.add(new Book("The Hunger Games", "Young Adult", 4.2, authors.get(7)));
        books.add(new Book("Gone Girl", "Thriller", 4.0, authors.get(8)));
        books.add(new Book("The Martian", "Science Fiction", 4.5, authors.get(9)));
    }
}
