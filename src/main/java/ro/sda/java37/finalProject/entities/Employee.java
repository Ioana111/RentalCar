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

  private String firstName;
  private String lastName;
  private String position;
  @ManyToOne
  private Branch workingBranch;


}
