package com.dev.sayan.algocamp.springdatajpaproject.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private int id;
    private String name;
    private Boolean isWorking;
}
