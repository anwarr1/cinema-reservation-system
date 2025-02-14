package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Movie {
    @ManyToOne
    Category category;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    List<MovieShowTime> movieShowTimes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
}