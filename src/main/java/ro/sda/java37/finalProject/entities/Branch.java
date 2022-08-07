package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private List<Employee> facilityEmployees;
    private List<Car> currentlyAvailableCars;
}
