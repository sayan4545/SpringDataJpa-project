package com.dev.sayan.algocamp.springdatajpaproject.advices;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
}
