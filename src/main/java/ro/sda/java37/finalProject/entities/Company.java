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
  private String companyName;
  private String internetDomain;
  private String contactAddress;

  private String owner;
  private String logoType;

  @OneToMany
  private List<Branch> branches;

  @OneToMany
  private List<Customer> customers;


}
