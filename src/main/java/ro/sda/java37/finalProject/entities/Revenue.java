package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Revenue {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal sumOfAmountsForCarRental;

}
