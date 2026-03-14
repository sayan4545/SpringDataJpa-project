package com.dev.sayan.algocamp.springdatajpaproject.dto;

import com.dev.sayan.algocamp.springdatajpaproject.entities.Location;
import com.dev.sayan.algocamp.springdatajpaproject.entities.Project;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String employeeName;
    private String employeeEmailId;
    private int employeeAge;
    private Long employeeSalary;
    private LocalDate employeeDoj;
    private Location emplReportingOffice;
    private List<Project> emplTaggedProject;
}
