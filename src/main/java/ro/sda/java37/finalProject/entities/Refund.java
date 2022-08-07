package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Refund {

    @Id
    @GeneratedValue
    private Long id;
    private Employee employee;
    public Date dateOfReturn;
    public Reservation reservation;
    public BigDecimal surcharge;
    public String comments;
}
