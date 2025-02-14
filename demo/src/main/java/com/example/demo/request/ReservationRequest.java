package com.example.demo.request;

import com.example.demo.model.Seat;
import lombok.Data;

@Data
public class ReservationRequest {
    private Integer showTimeId;

    private Seat seat;

}
