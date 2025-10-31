package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.repository.BookReservationRepository;
import mk.finki.ukim.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, Long numOfCopies) {
        BookReservation reservation = new BookReservation(bookTitle, readerName, readerAddress, numOfCopies);
        return bookReservationRepository.save(reservation);
    }
}
