package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.services.CarService;

@Controller
@AllArgsConstructor
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;
    //create car
    //find all cars
    //search by def criteria
    @GetMapping()
    public CarDto createCar(@RequestBody CarDto car){
       return carService.createCar(car);
    }
}
