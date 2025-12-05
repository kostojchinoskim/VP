package mk.finki.ukim.lab.repository.mock.impl;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.models.BookReservation;
import mk.finki.ukim.lab.repository.mock.InMemoryBookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepositoryImpl implements InMemoryBookReservationRepository {

    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
