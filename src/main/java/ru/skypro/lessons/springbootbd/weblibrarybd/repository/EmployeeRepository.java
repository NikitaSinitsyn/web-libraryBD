package ru.skypro.lessons.springbootbd.weblibrarybd.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeDTO;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeFullInfoDTO;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Department;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Employee;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(emp.salary) FROM Employee emp)")
    List<Employee> getEmployeesWithHighestSalary();

    @Query("SELECT e FROM Employee e WHERE e.position = :position")
    List<Employee> findEmployeesByPosition(@Param("position") String position);

    @Query("SELECT e.id, e.name, e.salary, e.position FROM Employee e WHERE e.id = :id")
    Optional<EmployeeFullInfoDTO> getEmployeeFullInfoById(@Param("id") int id);

    @Query(value = "SELECT e FROM Employee e",
            countQuery = "SELECT COUNT(e) FROM Employee e")
    Page<Employee> findAllEmployees(Pageable pageable);


    List<Employee> findByDepartment(Department department);
}
