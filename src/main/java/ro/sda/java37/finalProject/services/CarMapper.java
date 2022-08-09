package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;

@Service
public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto convertToDto(Car entity) {
        CarDto result = new CarDto();
        result.setId(entity.getId());
        result.setAvailable(entity.isAvailable());
        result.setBodyType(entity.getBodyType());
        result.setBrand(entity.getBrand());
        result.setColor(entity.getColor());
        result.setAmountPerDay(entity.getAmountPerDay());
        result.setMileage(entity.getMileage());
        result.setModel(entity.getModel());
        result.setYear(entity.getYear());
        return result;
    }

    @Override
    public Car convertToEntity(CarDto dto) {
        Car result = new Car();
        result.setId(dto.getId());
        result.setAvailable(dto.isAvailable());
        result.setBodyType(dto.getBodyType());
        result.setBrand(dto.getBrand());
        result.setColor(dto.getColor());
        result.setAmountPerDay(dto.getAmountPerDay());
        result.setMileage(dto.getMileage());
        result.setModel(dto.getModel());
        result.setYear(dto.getYear());
        return result;

    }
}
