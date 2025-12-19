package mk.finki.ukim.lab.web.controllers;


import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.service.AuthorService;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String filterAuthorId,
                               Model model,
                               HttpSession session)
    {
        if(error != null) {
            model.addAttribute("error", error);
        }

        List<Book> books;
        List<String> lastViewed = (List<String>) session.getAttribute("lastViewed");

        long authorId = -1;
        try {
            authorId = Long.parseLong(filterAuthorId);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(authorId != -1) {
            books = bookService.findBooksByAuthorId(authorId);
        } else {
            books = bookService.listAll();
        }



//        if(filterAuthorId != null && !filterAuthorId.isBlank()) {
//            authorId = Long.parseLong(filterAuthorId);
//        }



        model.addAttribute("books", books);
        model.addAttribute("lastViewedBooks", lastViewed);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("filteredId", authorId);

        return "listBooks";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam(required = false) Double averageRating,
                           @RequestParam(required = false) Long authorId)
    {
        if(averageRating == null || authorId == null){
            return "redirect:/books?error=InvalidInput";
        }
        bookService.add(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/book-form/{bookId}")
    public String getEditBookForm(@PathVariable Long bookId, Model model) {
        if(bookId == null) {
            return "redirect:/books?error=BookNotFound";
        }

        Book book = bookService.findBook(bookId);
        model.addAttribute("bookId", book.getId());
        model.addAttribute("title", book.getTitle());
        model.addAttribute("genre", book.getGenre());
        model.addAttribute("averageRating", book.getAverageRating());
        Author author = book.getAuthor();
        model.addAttribute("authorId", author != null ? author.getId() : -1);
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId)
    {
        bookService.update(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
