package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RevenueDto {
    private Long id;
    private BigDecimal sumOfAmountsForCarRental;

}
