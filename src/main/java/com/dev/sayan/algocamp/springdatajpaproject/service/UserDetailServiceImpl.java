package com.dev.sayan.algocamp.springdatajpaproject.service;

import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserService{
    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDetails saveUser(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }

    public UserDetails putEmployee(Long id, UserDetails userdetails) {
        return userDetailsRepository.findById(id)
                .map(existingUser -> {
                    modelMapper.map(userdetails, existingUser);
                    existingUser.setId(id);

                    return userDetailsRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
