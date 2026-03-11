package com.dev.sayan.algocamp.springdatajpaproject.controllers;
import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import com.dev.sayan.algocamp.springdatajpaproject.repositories.UserDetailsRepository;
import com.dev.sayan.algocamp.springdatajpaproject.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailServiceImpl userDetailService;
    private final UserDetailsRepository userDetailsRepository;

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
    @PatchMapping(path ="/updatePartialUser/{id}")
    public ResponseEntity<UserDetails> updatePartialUser(@RequestBody Map<String,Object> updates, @PathVariable Long id){
        return ResponseEntity.ok(userDetailService.updatePartialUser(id,updates));
    }
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Optional<UserDetails>> findUserById(@PathVariable Long id){
        return ResponseEntity.ok(userDetailService.findUserById(id));
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id){
        return ResponseEntity.ok(userDetailService.deleteUserById(id));
    }


}
