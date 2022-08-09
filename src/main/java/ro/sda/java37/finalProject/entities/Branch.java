package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @OneToMany(mappedBy = "workingBranch")
    private List<Employee> facilityEmployees;


}