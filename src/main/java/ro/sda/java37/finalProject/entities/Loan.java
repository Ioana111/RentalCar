package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Loan {

  @Id
  @GeneratedValue
  private Long id;

  private Date dateOfRental;
  private String comments;

  @OneToOne
  private Reservation reservation;
  @ManyToOne
  private Employee employee;

}
