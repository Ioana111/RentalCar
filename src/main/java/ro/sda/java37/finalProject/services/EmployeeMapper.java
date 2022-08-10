package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.EmployeeDto;
import ro.sda.java37.finalProject.entities.Employee;

@Service
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {

  @Override
  public EmployeeDto convertToDto(Employee entity) {
    EmployeeDto result = new EmployeeDto();
//    result.setEmployeeId(entity.getEmployeeId());
    result.setFirstName(entity.getFirstName());
    result.setLastName(entity.getLastName());
    result.setPosition(entity.getPosition());
    return result;
  }

  @Override
  public Employee convertToEntity(EmployeeDto dto) {
    Employee result = new Employee();
//    result.setEmployeeId(dto.getEmployeeId());
    result.setFirstName(dto.getFirstName());
    result.setLastName(dto.getLastName());
    result.setPosition(dto.getPosition());
    return result;

  }


}
