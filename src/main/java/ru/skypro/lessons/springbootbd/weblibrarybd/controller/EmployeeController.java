package ru.skypro.lessons.springbootbd.weblibrarybd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springbootbd.weblibrarybd.CustomExceptionHandler.PositionNotFoundException;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeDTO;
import ru.skypro.lessons.springbootbd.weblibrarybd.DTO.EmployeeFullInfoDTO;
import ru.skypro.lessons.springbootbd.weblibrarybd.repository.PositionRepository;
import ru.skypro.lessons.springbootbd.weblibrarybd.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final PositionRepository positionRepository;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/position/{positionId}")
    public List<EmployeeDTO> getEmployeesByPosition(@PathVariable int positionId) {
        positionRepository.findById(positionId)
                .orElseThrow(() -> new PositionNotFoundException("Position not found with id: " + positionId));

        return employeeService.getEmployeesByPosition(positionId);
    }
    @GetMapping("/withHighestSalary")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesWithHighestSalary() {
        List<EmployeeDTO> employees = employeeService.getEmployeesWithHighestSalary();
        return ResponseEntity.ok(employees);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findEmployeesByPosition(@RequestParam(value = "position", required = false) int position) {
        List<EmployeeDTO> employees = employeeService.findEmployeesByPosition(String.valueOf(position));
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}/fullInfo")
    public ResponseEntity<EmployeeFullInfoDTO> getEmployeeFullInfo(@PathVariable int id) {
        EmployeeFullInfoDTO employeeFullInfo = employeeService.getEmployeeFullInfoById(id);
        return ResponseEntity.ok(employeeFullInfo);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeDTO>> getEmployeesByPage(@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<EmployeeDTO> employeesPage = employeeService.getAllEmployeesByPage(page);
        return ResponseEntity.ok(employeesPage);
    }
}
