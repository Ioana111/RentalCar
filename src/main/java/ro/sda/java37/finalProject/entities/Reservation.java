package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data

public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private String dateOfBooking;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Car car;

    private String dateFrom;
    private String dateTo;

    @ManyToOne
    private Branch branchOfLoan;

    @ManyToOne
    private Branch returnBranch;

    private BigDecimal totalAmount; //sum of all reservation days - final price

    private BigDecimal warranty;



}
