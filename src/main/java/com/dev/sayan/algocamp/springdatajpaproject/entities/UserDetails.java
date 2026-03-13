package com.dev.sayan.algocamp.springdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String emailId;
    private LocalDate doj;
    private int age;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonProperty("isWorking")
    private Boolean isWorking;


}
