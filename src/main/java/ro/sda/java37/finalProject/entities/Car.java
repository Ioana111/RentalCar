package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    private String model;

    private String bodyType;

    private Integer year;

    private String color;

    private Integer mileage;

    private boolean isAvailable;

    private BigDecimal amountPerDay;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;





}