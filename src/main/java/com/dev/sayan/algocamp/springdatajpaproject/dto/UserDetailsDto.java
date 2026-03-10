package com.dev.sayan.algocamp.springdatajpaproject.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private String name;
    private Boolean isWorking;
}
