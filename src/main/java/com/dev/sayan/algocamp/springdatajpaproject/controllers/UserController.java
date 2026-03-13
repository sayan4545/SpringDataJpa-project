package com.dev.sayan.algocamp.springdatajpaproject.controllers;
import com.dev.sayan.algocamp.springdatajpaproject.advices.exceptions.ResourceNotFoundException;
import com.dev.sayan.algocamp.springdatajpaproject.dto.UserDetailsDto;
import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.repositories.UserDetailsRepository;
import com.dev.sayan.algocamp.springdatajpaproject.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailServiceImpl userDetailService;
    private final UserDetailsRepository userDetailsRepository;

    @PostMapping(path ="/saveUser")
    public ResponseEntity<UserDetails> saveUser(@Valid  @RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailService.saveUser(userDetailsDto));
    }
    @GetMapping(path ="/getUsers")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers(){
        return ResponseEntity.ok(userDetailService.getAllUsers());
    }

    @PutMapping(path = "/putEmployee/{id}")
    public ResponseEntity<UserDetailsDto> putEmployee(@Valid @RequestBody UserDetailsDto userDetailsDto, @PathVariable Long id){
        return new ResponseEntity<>(userDetailService.putEmployee(id,userDetailsDto),HttpStatus.NOT_FOUND);
    }
    @PatchMapping(path ="/updatePartialUser/{id}")
    public ResponseEntity<UserDetails> updatePartialUser(@Valid @RequestBody Map<String,Object> updates, @PathVariable Long id){
        return new ResponseEntity<>(userDetailService.updatePartialUser(id,updates),HttpStatus.NOT_FOUND);
    }
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<UserDetailsDto> findUserById(@PathVariable Long id){
        //if(userDetailService.findUserById(id)) throw new ResourceNotFoundException("Element Not found with this particular id");
        //return ResponseEntity.ok(userDetailService.findUserById(id));
        //return new ResponseEntity<>(userDetailService.findUserById(id),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDetailService.findUserById(id),HttpStatusCode.valueOf(400));


    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<UserDetailsDto> deleteUserById(@PathVariable Long id){
        return new ResponseEntity<>(userDetailService.deleteUserById(id),HttpStatus.NOT_FOUND);
    }


}
