package ru.skypro.lessons.springbootbd.weblibrarybd.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Employee;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Position;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDTO {
    private String name;
    private double salary;
    private Position position;

    public EmployeeDTO() {

    }


}
