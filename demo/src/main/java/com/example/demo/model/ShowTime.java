package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String time;
    private String date;
    @OneToMany(mappedBy = "showTime")
    @JsonManagedReference
    private List<MovieShowTime> movieShowTimes = new ArrayList<>();


}
