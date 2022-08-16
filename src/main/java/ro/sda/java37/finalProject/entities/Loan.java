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
  @NotNull(message = "Date format should be MM/dd/yyyy")// trebuie sa facem exceptie aici)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateOfRental;
  @NotEmpty
  private String comments;

  @OneToOne
  private Reservation reservation;
  @ManyToOne
  private Employee employee;

}
