package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.entities.Employee;

public class EmployeeMapper implements Mapper<Employee,EmployeeMapper> {
    @Override
    public EmployeeMapper convertToDto(Employee entity) {
        return null;
    }

    @Override
    public Employee convertToEntity(EmployeeMapper dto) {
        return null;
    }
}
