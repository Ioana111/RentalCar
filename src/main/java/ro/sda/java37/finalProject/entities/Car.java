package ro.sda.java37.finalProject.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Entity
@Data
public class Car {
  @Id
  @GeneratedValue
  private Long id;

  @NotEmpty
  @Length(min = 3, message = "Brand should have at least 3 characters.")
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
  @ManyToOne
  private Branch branch;

  @OneToMany(mappedBy = "car")
  private List<Reservation> reservations;


}
