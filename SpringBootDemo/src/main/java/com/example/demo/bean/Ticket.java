package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private String flightNumber;

    private String company;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;

    private String price;
}
