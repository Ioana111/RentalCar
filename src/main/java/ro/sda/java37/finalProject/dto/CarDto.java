package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private Integer year;
    private String color;
    private Integer mileage;
    private boolean isAvailable;
    private BigDecimal amountPerDay;
}
