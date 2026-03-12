package com.dev.sayan.algocamp.springdatajpaproject.dto;

import com.dev.sayan.algocamp.springdatajpaproject.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

import static com.dev.sayan.algocamp.springdatajpaproject.entities.Role.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Email
    private String emailId;
    private LocalDate doj;
    @Min(value = 18,message = "Must be 18 years or more")
    @Max(value= 120,message = "No upper cap on maximum age")
    private int age;

    //@Pattern(regexp = "^(ADMIN|USER|IT|INFRA)$")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @JsonProperty("isWorking")
    private Boolean isWorking;
}
