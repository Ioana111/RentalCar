package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue
    private Long id;
    private Employee employee;
    private Date dateOfRental;
    private Reservation reservation;
    private String comments;
}
