package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.aspectj.apache.bcel.ExceptionConstants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Refund {

  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private Employee employee;
  @OneToOne
  public Reservation reservation;

  public Date dateOfReturn;
  public BigDecimal surcharge;
  public String comments;
}
