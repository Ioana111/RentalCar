package ro.sda.java37.finalProject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import ro.sda.java37.finalProject.entities.Branch;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data

public class CarDto {
  private Long id;
  @NotEmpty
  @Length(min = 3)
  private String brand;
  @NotEmpty
  private String model;
  @NotEmpty
  private String bodyType;
  @NotNull
  private Integer year;
  @NotEmpty
  private String color;
  @NotNull
  private Integer mileage;
  private boolean isAvailable;
  @NotNull
  private BigDecimal amountPerDay;
  private BranchDto branch;

}
