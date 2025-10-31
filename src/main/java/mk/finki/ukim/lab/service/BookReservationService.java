package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.models.BookReservation;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAdress, Long numOfCopies);
}
