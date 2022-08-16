package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoanDto {
    private Long id;
    private String dateOfRental;
    private String comments;

}
