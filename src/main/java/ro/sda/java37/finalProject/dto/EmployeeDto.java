package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class EmployeeDto {
  private Long employeeId;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @NotEmpty
  private String position;
}
