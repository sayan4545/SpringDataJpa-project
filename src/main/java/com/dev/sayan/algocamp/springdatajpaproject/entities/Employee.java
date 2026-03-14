package com.dev.sayan.algocamp.springdatajpaproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeEmailId;
    private int employeeAge;
    private Long employeeSalary;
    private LocalDate employeeDoj;
    @Enumerated(EnumType.STRING)
    private Location emplReportingOffice;
    @OneToMany
    private List<Project> emplTaggedProject;

}
