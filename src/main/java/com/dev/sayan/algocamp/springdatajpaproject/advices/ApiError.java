package com.dev.sayan.algocamp.springdatajpaproject.advices;


import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private List<String> subErrors;
}
