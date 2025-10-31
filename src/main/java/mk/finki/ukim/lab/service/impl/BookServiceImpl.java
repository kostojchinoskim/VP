package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.repository.BookRepository;
import mk.finki.ukim.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    @Override
    public  List<Book> searchBooks(String text, double rating){
        return bookRepository.searchBooks(text, rating);
    }
}
