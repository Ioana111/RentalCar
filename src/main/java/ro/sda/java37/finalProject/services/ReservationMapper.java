package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.ReservationDto;
import ro.sda.java37.finalProject.entities.Reservation;

import java.text.SimpleDateFormat;

@Service
public class ReservationMapper implements Mapper<Reservation, ReservationDto> {

  @Override
  public ReservationDto convertToDto(Reservation entity) {
    ReservationDto result = new ReservationDto();
    result.setId(entity.getId());
    result.setDateFrom(entity.getDateFrom());
    result.setDateOfBooking(entity.getDateOfBooking());
    result.setDateTo(entity.getDateTo());
    result.setWarranty(entity.getWarranty());
    result.setTotalAmount(entity.getTotalAmount());
    return result;
  }

  @Override
  public Reservation convertToEntity(ReservationDto dto) {
    Reservation result = new Reservation();
    result.setDateFrom(dto.getDateFrom());
    result.setDateOfBooking(dto.getDateOfBooking());
    result.setDateTo(dto.getDateTo());
    result.setWarranty(dto.getWarranty());
    result.setTotalAmount(dto.getTotalAmount());
    return result;
  }
}
