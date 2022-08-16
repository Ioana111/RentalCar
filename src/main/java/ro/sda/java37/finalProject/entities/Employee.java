package ro.sda.java37.finalProject.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Employee {
  @Id
  @GeneratedValue
  private Long employeeId;

  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @NotEmpty
  private String position;
  @ManyToOne
  private Branch workingBranch;


}
