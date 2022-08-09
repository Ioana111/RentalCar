package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.repository.CarRepository;

@Service
@AllArgsConstructor
public class CarService {
CarMapper carMapper;
CarRepository carRepository;

    public CarDto createCar(CarDto car) {
        Car carEntity= carMapper.convertToEntity(car);
        carRepository.save(carEntity);
        return carMapper.convertToDto(carEntity);
    }
}
