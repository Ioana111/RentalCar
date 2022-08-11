package ro.sda.java37.finalProject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CarDto {
  private Long id;
  @NotEmpty
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
}
