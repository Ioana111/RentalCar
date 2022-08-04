package ro.sda.java37.finalProject.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Refund {

    private Long id;
    private Employee employee;
    public Date dateOfReturn;
    public Reservation reservation;
    public BigDecimal surcharge;
    public String comments;
}
