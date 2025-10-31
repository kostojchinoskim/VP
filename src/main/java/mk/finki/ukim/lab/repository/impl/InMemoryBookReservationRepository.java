package mk.finki.ukim.lab.repository.impl;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {

    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
