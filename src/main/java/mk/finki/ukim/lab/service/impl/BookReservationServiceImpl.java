package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.repository.mock.InMemoryBookReservationRepository;
import mk.finki.ukim.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final InMemoryBookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(InMemoryBookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, Long numOfCopies) {
        BookReservation reservation = new BookReservation(bookTitle, readerName, readerAddress, numOfCopies);
        return bookReservationRepository.save(reservation);
    }
}
