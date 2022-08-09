package ro.sda.java37.finalProject.DTO;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String position;
}
