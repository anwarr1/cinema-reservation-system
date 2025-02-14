package com.example.demo.service;

import com.example.demo.model.MovieShowTime;
import com.example.demo.model.Reservation;
import com.example.demo.model.Seat;
import com.example.demo.model.User;
import com.example.demo.repository.MovieShowTimeRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieShowTimeRepository movieShowTimeRepository;
    @Autowired
    SeatRepository seatRepository;

    public Reservation addOrUpdateReservation(Seat seat) {
        User user = userRepository.findById(2).get();
        seat = seatRepository.findById(Long.valueOf(seat.getId())).get();
        System.out.println("Seat " + seat.getSeatNumber());
        MovieShowTime movieShowTime = seat.getMovieShowTime();
        int availableSeats = movieShowTime.getAvailableSeats();
        if (availableSeats == 0) {
            throw new RuntimeException("No seats available");
        }

        movieShowTime.setAvailableSeats(movieShowTime.getAvailableSeats() - 1);
        Reservation reservation = new Reservation();
        if (!seat.isBooked()) {
            reservation.setMovieShowTime(movieShowTime);
            reservation.setUser(user);
            Seat existingSeat = seatRepository.findById(Long.valueOf(seat.getId()))
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

//            reservation.getSeats().add(seat);
            reservation.setSeat(seat);
            existingSeat.setBooked(true);
            seatRepository.save(existingSeat);
        } else throw new RuntimeException("Seat already");

        return reservationRepository.save(reservation);
    }

    public Reservation deleteReservation(Reservation reservation) {

        reservationRepository.delete(reservation);
        return reservation;
    }
}
