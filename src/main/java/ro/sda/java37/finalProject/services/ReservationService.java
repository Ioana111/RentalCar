package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.ReservationDto;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Reservation;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.ReservationRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService {

  ReservationMapper reservationMapper;
  ReservationRepository reservationRepository;

  public ReservationDto createReservation(ReservationDto reservation) {
    Reservation reservationEntity = reservationMapper.convertToEntity(reservation);
    reservationRepository.save(reservationEntity);
    return reservationMapper.convertToDto(reservationEntity);
  }

  public List<ReservationDto> listAllReservation() {
    return reservationRepository.findAll().stream().map(r -> reservationMapper.convertToDto(r)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified reservation with %s does not exist", id)));
    reservationRepository.deleteById(id);
  }

  public void updateObject(Long id, Reservation reservation) {
    reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified reservation with %s does not exist", id)));
    reservationRepository.save(reservation);
  }

}
