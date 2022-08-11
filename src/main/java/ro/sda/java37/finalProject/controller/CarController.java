package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.services.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
@CrossOrigin(origins ="http://localhost:4200")
public class CarController {
    private CarService carService;
    //create car
    //find all cars
    //search by def criteria
    @PostMapping()
    public CarDto createCar(@RequestBody CarDto car){
       return carService.createCar(car);
    }

    @GetMapping()
    public List<CarDto> listAllCars(){
        return carService.listAllCars();
    }

    @PostMapping("/search")
    public List<CarDto> listAllCars(CarDto search){
        return carService.search(search);
    }

  @GetMapping ("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCarById(@PathVariable("id") Long id){
    carService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCarById(@RequestBody Car car, @PathVariable Long id) {
    carService.updateObject(id, car);
  }
}
