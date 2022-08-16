package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue
    private Long id;


    private String address;
  @AssertTrue
  public boolean isAddressValid() {
    return address != null && address.split(" ").length >= 2;
  }



  @OneToMany(mappedBy = "workingBranch")
    private List<Employee> facilityEmployees;


}
