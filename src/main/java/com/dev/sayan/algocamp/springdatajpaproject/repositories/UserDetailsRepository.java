package com.dev.sayan.algocamp.springdatajpaproject.repositories;

import com.dev.sayan.algocamp.springdatajpaproject.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long>  {
}
