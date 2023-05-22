package ru.skypro.lessons.springbootbd.weblibrarybd.DTO;
import lombok.*;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Employee;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Position;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeFullInfoDTO {
    private int id;
    private String name;
    private double salary;
    private Position position;


}
