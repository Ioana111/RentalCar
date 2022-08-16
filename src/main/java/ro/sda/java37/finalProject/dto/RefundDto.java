package ro.sda.java37.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RefundDto {
  private Long id;
  @NotNull // trebuie sa facem exceptie aici
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  public Date dateOfReturn;
  @NotNull
  public BigDecimal surcharge;
  @NotEmpty
  public String comments;
}
