package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    private Date dateOfBooking;
    private Customer client;
    private Car car;
    private Date dateFrom;
    private Date dateTo;
    private Branch branchOfLoan;
    private String returnDepartment; //department to be
    private BigDecimal amount;

}
