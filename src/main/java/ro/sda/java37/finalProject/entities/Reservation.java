package ro.sda.java37.finalProject.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Reservation {

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
