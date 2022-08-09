package ro.sda.java37.finalProject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Revenue {

    private Long id;
    private BigDecimal sumOfAmountsForCarRental;

}
