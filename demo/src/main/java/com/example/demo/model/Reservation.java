package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reservation {
    @ManyToOne
    User user;
    @ManyToOne
    MovieShowTime movieShowTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Seat seat;
}







