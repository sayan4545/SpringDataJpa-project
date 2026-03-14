package com.dev.sayan.algocamp.springdatajpaproject.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    private ProjectGrade projectGrade;
    private int projStrength;
    private LocalDate projStartDate;
    private LocalDate projCycleEndDate;
    @ManyToAny
    @JoinColumn(referencedColumnName = "employeeId")
    private Employee employee;

}
