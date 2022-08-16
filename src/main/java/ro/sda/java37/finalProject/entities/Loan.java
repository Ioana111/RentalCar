package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Loan {

  @Id
  @GeneratedValue
  private Long id;

  private String comments;

  private String dateOfRental;

  @OneToOne
  private Reservation reservation;
  @ManyToOne
  private Employee employee;

}
