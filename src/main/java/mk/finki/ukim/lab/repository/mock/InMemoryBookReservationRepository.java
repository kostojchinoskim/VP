package mk.finki.ukim.lab.repository.mock;

import mk.finki.ukim.lab.models.BookReservation;

public interface InMemoryBookReservationRepository {
    BookReservation save(BookReservation reservation);
}
