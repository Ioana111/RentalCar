package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
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
