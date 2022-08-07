package ro.sda.java37.finalProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private Year year; // integer or year?
    private String color;
    private Integer mileage;
    private String status;

}
