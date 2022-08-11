package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.EmployeeDto;
import ro.sda.java37.finalProject.entities.Employee;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
  EmployeeRepository employeeRepository;
  EmployeeMapper employeeMapper;

  public EmployeeDto createEmployee(EmployeeDto employee) {
    Employee employeeEntity = employeeMapper.convertToEntity(employee);
    employeeRepository.save(employeeEntity);
    return employeeMapper.convertToDto(employeeEntity);
  }

  public List<EmployeeDto> listAllEmployees() {
    return employeeRepository.findAll().stream().map(e -> employeeMapper.convertToDto(e)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Employee with %s was not found", id)));
    employeeRepository.deleteById(id);
  }

  public void updateById(Long id, Employee employee){
    employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Employee with %s was not found", id)));
    employeeRepository.save(employee);
  }
}
