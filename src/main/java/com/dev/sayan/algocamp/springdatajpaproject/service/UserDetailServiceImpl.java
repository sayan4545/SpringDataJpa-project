package com.dev.sayan.algocamp.springdatajpaproject.service;

import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserService{
    private final UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails saveUser(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }
}
