package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.AssertTrue;

@Data
public class BranchDto {

  private Long id;
  private String address;

  @AssertTrue
  public boolean isAddressValid() {
    return address != null && address.split(" ").length >= 2;
  }


}
