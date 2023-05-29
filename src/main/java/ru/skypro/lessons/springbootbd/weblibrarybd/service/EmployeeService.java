package ru.skypro.lessons.springbootbd.weblibrarybd.service;

import org.springframework.data.domain.Page;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeDTO;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeFullInfoDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void createEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);

    List<EmployeeDTO> getEmployeesByPosition(int positionId);

    List<EmployeeDTO> getEmployeesWithHighestSalary();

    List<EmployeeDTO> findEmployeesByPosition(String position);
    EmployeeFullInfoDTO getEmployeeFullInfoById(int id);

    Page<EmployeeDTO> getAllEmployeesByPage(int page);

}
