package mk.finki.ukim.lab.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @GetMapping
    public String getBookReservation(@RequestParam(required = false) String error,
                                     @RequestParam(required = false) String readerName,
                                     @RequestParam(required = false) String bookTitle,
                                     @RequestParam(required = false) String ipAddress,
                                     @RequestParam(required = false) String numberOfCopies,
                                     Model model
    ) {
        if(error != null) {
            model.addAttribute("error", error);
        }

        model.addAttribute("readerName", readerName);
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("numberOfCopies", numberOfCopies);

        return "reservationConfirmation";
    }

    @PostMapping
    public String postBookReservation(@RequestParam String bookTitle,
                                      @RequestParam String readerName,
                                      @RequestParam String readerAddress,
                                      @RequestParam String numCopies,
                                      HttpServletRequest request,
                                      Model model
    ){
        Long numberOfCopies = Long.parseLong(numCopies);
        BookReservation bookReservation = bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);

        model.addAttribute("readerName", bookReservation.getReaderName());
        model.addAttribute("bookTitle", bookReservation.getBookTitle());
        model.addAttribute("readerAddress", request.getRemoteAddr());
        model.addAttribute("numberOfCopies", bookReservation.getNumberOfCopies());

//        List<String> lastViewed = new ArrayList<>();
//        Object lastViewedSessionObject = request.getSession().getAttribute("lastViewed");
//        if(lastViewedSessionObject != null) {
//            lastViewed = (List<String>) lastViewedSessionObject;
//            if(lastViewed.size() >= MAX_RECENTLY_VIEWED) {
//                lastViewed.removeLast();
//            }
//        }
//        lastViewed.addFirst(bookReservation.getBookTitle());
//        request.getSession().setAttribute("lastViewed", lastViewed);

        return "reservationConfirmation";
    }
}
