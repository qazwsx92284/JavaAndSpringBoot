package com.min0.violation.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EnableAutoConfiguration
@RequiredArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeNumber;

    private String pin;

    private String violationType;
    private LocalDateTime violationDate;
    private double fee;
    private boolean paid;
    private LocalDateTime paymentDate;
    private LocalDateTime dueDate;

    private String firstName;
    private String lastName;

    private String state;
    private String city;
    private String address;
    private String zipcode;
}
