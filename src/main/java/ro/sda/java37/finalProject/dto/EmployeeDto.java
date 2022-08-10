package ro.sda.java37.finalProject.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String position;
}
