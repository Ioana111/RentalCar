package ro.sda.java37.finalProject.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Reservation {
    private Date dateOfBooking;
    private Customer client;
    private Car car;
    private Date dateFrom;
    private Date dateTo;
    private Loan branchOfLoan;
    private String returnDepartment;
    private BigDecimal amount;
}
