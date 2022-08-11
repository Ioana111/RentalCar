package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.EmployeeDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Employee;
import ro.sda.java37.finalProject.services.EmployeeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

  private EmployeeService employeeService;

  @PostMapping()
  public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping()
  public List<EmployeeDto> listAllEmployees() {
    return employeeService.listAllEmployees();
  }

  @GetMapping("delete/{employeeId}")
  public void deleteEmployeeById(@PathVariable("employeeId") Long id) {
    employeeService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateEmployeeById(@RequestBody Employee employee, @PathVariable Long id) {
    employeeService.updateById(id, employee);
  }



}
