package com.example.demo.repository;

import com.example.demo.model.MovieShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowTimeRepository extends JpaRepository<MovieShowTime, Integer> {

}
