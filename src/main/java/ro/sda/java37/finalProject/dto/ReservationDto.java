package ro.sda.java37.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Jacksonized
public class ReservationDto {

  private Long id;
  @NotNull
  //@JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dateOfBooking;
  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  private LocalDate dateFrom;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
 // @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate dateTo;
  @NotNull
  private BigDecimal totalAmount; //sum of all reservation days - final price
  @NotNull
  private BigDecimal warranty;
  //  private CarDto car;
  private long carId;

}
