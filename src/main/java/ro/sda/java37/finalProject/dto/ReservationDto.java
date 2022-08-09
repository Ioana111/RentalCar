package ro.sda.java37.finalProject.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReservationDto {
    private Long id;

    private Date dateOfBooking;
    private Date dateFrom;
    private Date dateTo;
    private BigDecimal totalAmount; //sum of all reservation days - final price

    private BigDecimal warranty;
}
