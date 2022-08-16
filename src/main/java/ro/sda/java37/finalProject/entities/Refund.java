package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.apache.bcel.ExceptionConstants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Refund {

  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private Employee employee;
  @OneToOne
  public Reservation reservation;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  public Date dateOfReturn;
  @NotNull
  public BigDecimal surcharge;
  @NotEmpty
  public String comments;
}
