package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.repository.CarRepository;
import ro.sda.java37.finalProject.repository.CarRepositorySearchCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
CarMapper carMapper;
CarRepository carRepository;
CarRepositorySearchCriteria carRepositorySearchCriteria;

    public CarDto createCar(CarDto car) {
        Car carEntity= carMapper.convertToEntity(car);
        carRepository.save(carEntity);
        return carMapper.convertToDto(carEntity);
    }

    public List<CarDto> listAllCars() {
        return carRepository.findAll().stream().map(c-> carMapper.convertToDto(c)).collect(Collectors.toList());
    }

    public List<CarDto> search(CarDto search) {
        return carRepositorySearchCriteria.findAllCars(search).stream().map(c->carMapper.convertToDto(c))
                .collect(Collectors.toList());    }
}
