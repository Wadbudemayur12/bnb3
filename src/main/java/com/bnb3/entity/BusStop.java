package com.bnb3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bus_stop")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bus_id", nullable = false, unique = true)
    private Integer busId;

    @Column(name = "stop_id", nullable = false, unique = true)
    private Integer stopId;

    @Column(name = "departure_time", nullable = false)
    private LocalDate departureTime;


}