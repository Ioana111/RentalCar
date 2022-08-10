package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoanDto {
    private Long id;
    private Date dateOfRental;
    private String comments;

}