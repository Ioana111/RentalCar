package ro.sda.java37.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DatesDto {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  LocalDate dateFrom;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  LocalDate dateTo;
}
