package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class Company {

  @Id
  @GeneratedValue
  private Long id;
  @NotEmpty
  private String companyName;
  @NotEmpty
  private String internetDomain;
  private String contactAddress;

  @AssertTrue
  public boolean isAddressValid() {
    return contactAddress != null && contactAddress.split(" ").length >= 2;
  }

  @NotEmpty
  private String owner;
  @NotEmpty
  private String logoType;

  @OneToMany
  private List<Branch> branches;

  @OneToMany
  private List<Customer> customers;


}
