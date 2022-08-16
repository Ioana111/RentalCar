package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class CustomerDto {
  private Long id;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @Email
  private String email;
  private String address;
  @AssertTrue
  public boolean isAddressValid() {
    return address != null && address.split(" ").length >= 2;
  }
}
