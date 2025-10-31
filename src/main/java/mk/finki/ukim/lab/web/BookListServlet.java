package mk.finki.ukim.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.lab.models.Book;
import mk.finki.ukim.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;


import java.util.List;
import java.io.IOException;

@WebServlet(name = "BookListServlet", urlPatterns = "")
public class BookListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;

    public BookListServlet(SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);

        List<Book> books = null;
        List<String> lastViewed = (List<String>) request.getSession().getAttribute("lastViewed");

        String filterName = request.getParameter("filterName");
        double filterRating = -1;

        try {
            filterRating = Double.parseDouble(request.getParameter("filterRating"));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(filterName != null && !filterName.isEmpty() && filterRating != -1) {
            books = bookService.searchBooks(filterName, filterRating);
        } else {
            books = bookService.listAll();
        }

        WebContext context = new WebContext(webExchange);
        context.setVariable("books", books);
        //context.setVariable("lastViewedBooks", lastViewed);

        springTemplateEngine.process("listBooks", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterName = request.getParameter("filterName");
        String filterRating = request.getParameter("filterRating");
        String params = String.format("filterName=%s&filterRating=%s", filterName, filterRating);
        response.sendRedirect("/?" + params);
    }
}