package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class MovieShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    @ToString.Exclude

    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "show_time_id")
    @JsonBackReference
    private ShowTime showTime;
    private String hall;
    private int availableSeats;
    private int totalSeats;

    @OneToMany(mappedBy = "movieShowTime")
    @JsonBackReference("reservation-showtime")
    private List<Reservation> reservations;

}