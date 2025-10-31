package mk.finki.ukim.lab.repository;

import mk.finki.ukim.lab.models.BookReservation;

public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}
