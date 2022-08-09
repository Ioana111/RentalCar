package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private int year;
    private String color;
    private int mileage;
    private boolean isAvailable;
    private BigDecimal amountPerDay;
}
