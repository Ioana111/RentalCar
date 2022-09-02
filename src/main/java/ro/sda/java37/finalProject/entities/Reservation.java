package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
public class Reservation {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDate dateOfBooking;
  @ManyToOne
  private Customer customer;
  @ManyToOne
  private Car car;

  private LocalDate dateFrom;

  private LocalDate dateTo;
  @ManyToOne
  private Branch branchOfLoan;
  @ManyToOne
  private Branch returnBranch;
  private BigDecimal totalAmount; //sum of all reservation days - final price
  private BigDecimal warranty;


}
