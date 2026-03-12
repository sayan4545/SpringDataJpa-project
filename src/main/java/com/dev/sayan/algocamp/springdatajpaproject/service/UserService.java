package com.dev.sayan.algocamp.springdatajpaproject.service;

import com.dev.sayan.algocamp.springdatajpaproject.dto.UserDetailsDto;
import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    UserDetails saveUser(UserDetailsDto userDetailsDto);
    List<UserDetailsDto> getAllUsers();
    UserDetailsDto putEmployee(Long id, UserDetailsDto userdetailsDto);

    UserDetails updatePartialUser(Long id, Map<String,Object> updates);

    Optional<UserDetails> findUserById(Long id);

    Boolean deleteUserById(Long id);
}
