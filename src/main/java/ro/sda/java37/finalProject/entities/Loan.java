package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    private Date dateOfRental;

    @OneToOne
    private Reservation reservation;

    private String comments;
}
