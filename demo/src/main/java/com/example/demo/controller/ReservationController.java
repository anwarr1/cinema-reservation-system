package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.Seat;
import com.example.demo.repository.SeatRepository;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    SeatRepository seatRepository;

    @GetMapping
    String test() {

        return "just a test";
    }

    @PostMapping
    Reservation reserver(@RequestBody Seat seat) {
//        seat = seatRepository.findById(Long.valueOf(seat.getId())).get();
        return reservationService.addOrUpdateReservation(
                seat);
    }
}
