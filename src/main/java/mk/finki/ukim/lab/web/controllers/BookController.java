package mk.finki.ukim.lab.web.controllers;


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

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String filterName,
                               @RequestParam(required = false) String filterRating,
                               Model model,
                               HttpSession session)
    {
        if (error != null) {
            model.addAttribute ("error", error);
        }

        List<Book> books;
        model.addAttribute("books", bookService.listAll());

        return "listBooks";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model){
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId)
    {
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
        model.addAttribute("authorId", book.getAuthor().getId());
        return "book-form";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @PathVariable String title,
                           @PathVariable String genre,
                           @PathVariable Double averageRating,
                           @PathVariable Long authorId)
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
