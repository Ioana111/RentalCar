package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@Data
public class BranchDto {

  private Long id;
  private String address;

  private List<CarDto> carDtoList;

  @AssertTrue
  public boolean isAddressValid() {
    return address != null && address.split(" ").length >= 2;
  }


}
