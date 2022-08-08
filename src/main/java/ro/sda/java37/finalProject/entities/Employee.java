package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String position; //manager or employee

    @ManyToOne
    private Branch workingBranch;


}
