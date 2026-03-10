package com.dev.sayan.algocamp.springdatajpaproject.controllers;
import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailServiceImpl userDetailService;

    @PostMapping(path ="/saveUser")
    public ResponseEntity<UserDetails> saveUser(@RequestBody UserDetails userDetails){
        return ResponseEntity.ok(userDetailService.saveUser(userDetails));
    }
    @GetMapping(path ="/getUsers")
    public ResponseEntity<List<UserDetails>> getAllUsers(){
        return ResponseEntity.ok(userDetailService.getAllUsers());
    }
    @PutMapping(path = "/putEmployee/{id}")
    public ResponseEntity<UserDetails> putEmployee(@RequestBody UserDetails userDetails, @PathVariable Long id){
        return ResponseEntity.ok(userDetailService.putEmployee(id,userDetails));
    }


}
