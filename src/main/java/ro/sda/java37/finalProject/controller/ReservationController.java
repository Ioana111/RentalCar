package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.dto.ReservationDto;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Reservation;
import ro.sda.java37.finalProject.services.ReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
  private ReservationService reservationService;

  @PostMapping
  public ReservationDto createReservation(@RequestBody ReservationDto reservation) {
    return reservationService.createReservation(reservation);
  }

  @GetMapping()
  public List<ReservationDto> listAllReservations() {
    return reservationService.listAllReservation();
  }

  @GetMapping("/delete/{id}")
  public void deleteReservationById(@PathVariable("id") Long id, Model model) {
    reservationService.deleteById(id);
  }

  @PutMapping("/api/reservation/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateReservationById(@RequestBody Reservation reservation, @PathVariable Long id) {
    reservationService.updateObject(id, reservation);
  }


}
