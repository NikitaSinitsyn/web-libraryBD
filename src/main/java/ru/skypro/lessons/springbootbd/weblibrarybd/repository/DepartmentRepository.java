package ru.skypro.lessons.springbootbd.weblibrarybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
