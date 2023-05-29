package ru.skypro.lessons.springbootbd.weblibrarybd.entity;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "newEmployee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull()
    private int id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @Min(value = 0, message = "Salary must be a positive number")
    private double salary;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
