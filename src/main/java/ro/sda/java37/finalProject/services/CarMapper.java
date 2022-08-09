package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.entities.Car;

public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto convertToDto(Car entity) {
        return null;
    }

    @Override
    public Car convertToEntity(CarDto dto) {
        return null;
    }
}
