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
//    public static List<Author> authors = new ArrayList<>();

    private final BookRepository bookRepository;
//    private final AuthorRepository authorRepository;
    public static Long bookIdCounter = 1L;

    public DataHolder(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){

        if(bookRepository.findAll().isEmpty()){
            books = new ArrayList<>();
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

//        if(authorRepository.findAll().isEmpty()){
//            authors = new ArrayList<>();
//            authors.add(new Author("J.K", "Rowling", "England", "J.K Rowling biography"));
//            authors.add(new Author("J.R.R", "Tolkien", "England", "J.R.R Tolkien biography"));
//            authors.add(new Author("George", "Orwell", "England", "George Orwell biography"));
//            authors.add(new Author("Andy", "Weir", "United States", "Andy Weir biography"));
//            authors.add(new Author("Douglas", "Adams", "England", "Douglas Adams biography"));
//            authors.add(new Author("Aldous", "Huxley", "England", "Aldous Huxley biography"));
//            authors.add(new Author("Mary", "Shelley", "England", "Mary Shelley biography"));
//            authors.add(new Author("Frank", "Herbert", "United States", "Frank Herbert biography"));
//            authors.add(new Author("Suzanne", "Collins", "United States", "Suzanne Collins biography"));
//            authors.add(new Author("Arthur C.", "Clarke", "England", "Arthur C. Clarke biography"));
//            authorRepository.saveAll(authors);
//        }

//        if(authorRepository.findAll().isEmpty()){
//            authorRepository.saveAll(List.of(
//               new Author("J.K", "Rowling", "England", "J.K Rowling biography"),
//               new Author("J.R.R", "Tolkien", "England", "J.R.R Tolkien biography"),
//               new Author("George", "Orwell", "England", "George Orwell biography"),
//               new Author("Andy", "Weir", "United States", "Andy Weir biography"),
//               new Author("Douglas", "Adams", "England", "Douglas Adams biography"),
//               new Author("Aldous", "Huxley", "England", "Aldous Huxley biography"),
//               new Author("Mary", "Shelley", "England", "Mary Shelley biography"),
//               new Author("Frank", "Herbert", "United States", "Frank Herbert biography"),
//               new Author("Suzanne", "Collins", "United States", "Suzanne Collins biography"),
//               new Author("Arthur C.", "Clarke", "England", "Arthur C. Clarke biography")
//            ));
//        }
//
//        if(bookRepository.findAll().isEmpty()){
//            bookRepository.save(
//                    new Book("The Great Gatsby", "Classic", 4.2,authorRepository.findById(1L).get())
//
//            );
//        }

    }
}
