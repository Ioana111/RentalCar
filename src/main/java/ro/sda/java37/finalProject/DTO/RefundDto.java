package ro.sda.java37.finalProject.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RefundDto {
    private Long id;
    public Date dateOfReturn;
    public BigDecimal surcharge;
    public String comments;
}
