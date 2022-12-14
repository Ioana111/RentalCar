package ro.sda.java37.finalProject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.dto.DatesDto;
import ro.sda.java37.finalProject.services.CarService;
import ro.sda.java37.finalProject.services.ReservationService;

import javax.validation.Valid;
import java.time.LocalDate;
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
  public CarDto createCar(@RequestBody CarDto car) {
    return carService.createCar(car);
  }

  @GetMapping()
  public List<CarDto> listAllCars() {
    return carService.listAllCars();
  }

  @GetMapping("/{id}")
  public CarDto getCarById(@PathVariable("id") Long id){ return carService.getCarById(id);}

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

//  @GetMapping("/availability")
//  @ResponseStatus(HttpStatus.OK)
//  public List<CarDto> listAllAvailableCars(@RequestBody DatesDto datesDto){
//    System.out.println(datesDto.getDateTo() + " " + datesDto.getDateFrom());
//    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//    return carService.retrieveAllAvailableCars(datesDto.getDateFrom(), datesDto.getDateTo());
//  }

  @GetMapping("/availability/{dateFrom}/{dateTo}")
  public ResponseEntity<List<CarDto>> listAllAvailableCars(@PathVariable("dateFrom") String dateFromString,
                                                           @PathVariable("dateTo") String dateToString){
    LocalDate dateFrom = LocalDate.parse(dateFromString);
    LocalDate dateTo = LocalDate.parse(dateToString);;

    List<CarDto> carDtoList = carService.retrieveAllAvailableCars(dateFrom,dateTo);
    return new ResponseEntity<>(carDtoList,HttpStatus.OK);
  }





}
