package com.dev.sayan.algocamp.springdatajpaproject.service;

import com.dev.sayan.algocamp.springdatajpaproject.dto.UserDetailsDto;
import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserService{
    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDetails saveUser(UserDetailsDto userDetailsDto) {
        UserDetails user = modelMapper
                .map(userDetailsDto,UserDetails.class);
        return userDetailsRepository.save(user);
    }

    @Override
    public List<UserDetailsDto> getAllUsers() {

        return userDetailsRepository.findAll()
                .stream()
                .map(userDetails -> modelMapper.map(userDetails, UserDetailsDto.class))
                .toList();
    }

    public UserDetailsDto putEmployee(Long id, UserDetailsDto userdetailsDto) {
        UserDetails userToBeUpdatedTo = modelMapper.map(userdetailsDto,UserDetails.class);
        return userDetailsRepository.findById(id)
                .map(existingUser -> {
                    modelMapper.map(userToBeUpdatedTo, existingUser);
                    existingUser.setId(id);

                    userDetailsRepository.save(existingUser);
                    return modelMapper.map(existingUser,UserDetailsDto.class);
                }).orElseThrow();

    }

    @Override
    public UserDetails updatePartialUser(Long id, Map<String, Object> updates) {
        UserDetails user = userDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not present with id " + id));

        updates.forEach((fieldName, value) -> {
            Field field = org.springframework.util.ReflectionUtils.findField(UserDetails.class, fieldName);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, user, value);
            }
        });

        return userDetailsRepository.save(user);
    }

    @Override
    public Optional<UserDetails> findUserById(Long id) {
        Boolean isExistById = userDetailsRepository.existsById(id);
        if(!isExistById) throw new RuntimeException("User donot exist ");
        return userDetailsRepository.findById(id);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        Boolean isExistById = userDetailsRepository.existsById(id);
        if(!isExistById) return false;
        userDetailsRepository.deleteById(id);
        return true;
    }
}
