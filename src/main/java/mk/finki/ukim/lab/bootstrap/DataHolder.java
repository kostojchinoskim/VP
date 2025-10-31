package mk.finki.ukim.lab.bootstrap;

import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.models.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>(10);
    public static List<BookReservation> reservations = new ArrayList<>();

    public void init(){
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
    }
}
