package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Rental {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logoType;
    private List<Branch> branches;

}
