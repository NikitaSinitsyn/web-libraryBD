package ru.skypro.lessons.springbootbd.weblibrarybd.entity;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Department name must not be blank")
    private String departmentName;

    private int employeeCount;

    private double maxSalary;

    private double minSalary;

    private double averageSalary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Lob
    private byte[] content;

    @Override
    public String toString() {
        return "Report{" +
                "departmentName='" + departmentName + '\'' +
                ", employeeCount=" + employeeCount +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                ", averageSalary=" + averageSalary +
                '}';
    }
}