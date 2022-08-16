package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Reservation {

  @Id
  @GeneratedValue
  private Long id;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateOfBooking;  @ManyToOne
  private Customer customer;
  @ManyToOne
  private Car car;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateFrom;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateTo;
  @ManyToOne
  private Branch branchOfLoan;
  @ManyToOne
  private Branch returnBranch;
  @NotNull
  private BigDecimal totalAmount; //sum of all reservation days - final price
  @NotNull
  private BigDecimal warranty;


}
