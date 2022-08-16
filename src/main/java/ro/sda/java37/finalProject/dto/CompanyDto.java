package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Data
public class CompanyDto {
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

}
