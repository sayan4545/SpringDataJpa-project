package com.dev.sayan.algocamp.springdatajpaproject.service;

import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetails saveUser(UserDetails userDetails);
    List<UserDetails> getAllUsers();
    UserDetails putEmployee(Long id, UserDetails userdetails);
}
