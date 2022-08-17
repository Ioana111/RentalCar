package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.dto.ReservationDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Reservation;
import ro.sda.java37.finalProject.services.CarService;
import ro.sda.java37.finalProject.services.ReservationService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
@CrossOrigin(origins = "http://localhost:4200")

public class CarController {
  private CarService carService;
  private ReservationService reservationService;


  //create car
  //find all cars
  //search by def criteria
  @PostMapping()
  public CarDto createCar(CarDto car) {
    return carService.createCar(car);
  }

  @GetMapping()
  public List<CarDto> listAllCars() {
    return carService.listAllCars();
  }

  /*The problem is that when we use application/x-www-form-urlencoded,
  Spring doesn't understand it as a RequestBody.
   So, if we want to use this we must remove the @RequestBody annotation./*
   */
  @PostMapping  ("/search")
  public List<CarDto> listAllCars(@RequestBody @Valid CarDto search) {
    return carService.search(search);
  }

  @GetMapping ("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCarById(@PathVariable("id") Long id) {
    carService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCarById(@RequestBody @Valid CarDto car, @PathVariable Long id) {
    carService.updateObject(id, car);
  }

  @PutMapping("/branch/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCarByBranchAfterRefund(@RequestBody Car car, @PathVariable Long id) {
    carService.updateCarByBranch(id, car.getBranch());
  }

  @GetMapping("/availability")
  public List<CarDto> listAllAvailableCars(@RequestBody Date dateFrom, Date dateTo){
    return carService.retrieveAllAvailableCars(dateFrom, dateTo);
  }





}
