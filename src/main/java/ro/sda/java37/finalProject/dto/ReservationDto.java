package ro.sda.java37.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReservationDto {

  private Long id;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateOfBooking;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateFrom;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateTo;
  @NotNull
  private BigDecimal totalAmount; //sum of all reservation days - final price
  @NotNull
  private BigDecimal warranty;

}
