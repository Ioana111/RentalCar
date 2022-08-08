package ro.sda.java37.finalProject.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class Refund {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    public Date dateOfReturn;

    @OneToOne
    public Reservation reservation;

    public BigDecimal surcharge; // warranty

    public String comments;
}
