package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;

import ro.sda.java37.finalProject.dto.ReservationDto;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Reservation;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.CarRepository;
import ro.sda.java37.finalProject.repository.CarRepositorySearchCriteria;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
  CarMapper carMapper;
  CarRepository carRepository;
  CarRepositorySearchCriteria carRepositorySearchCriteria;

  public CarDto createCar(CarDto car) {
    Car carEntity = carMapper.convertToEntity(car);
    carRepository.save(carEntity);
    return carMapper.convertToDto(carEntity);
  }

  public List<CarDto> listAllCars() {
    return carRepository.findAll().stream().map(c -> carMapper.convertToDto(c)).collect(Collectors.toList());
  }

  public List<CarDto> search(CarDto search) {
    return carRepositorySearchCriteria.findAllCars(search).stream().map(c -> carMapper.convertToDto(c))
      .collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    carRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified car with %s does not exist", id)));
    carRepository.deleteById(id);
  }

  public void updateObject(Long id, CarDto carDto) {
    Car entity = carRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified carDto with %s does not exist", id)));
    entity.setAvailable(carDto.isAvailable());
    entity.setBodyType(carDto.getBodyType());
    entity.setBrand(carDto.getBrand());
    entity.setColor(carDto.getColor());
    entity.setAmountPerDay(carDto.getAmountPerDay());
    entity.setMileage(carDto.getMileage());
    entity.setModel(carDto.getModel());
    entity.setYear(carDto.getYear());

    carRepository.save(entity);
  }

  public void updateCarByBranch(Long id, Branch branch) {
    Car carReturned = carRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified car with %s does not exist", id)));
    carReturned.setBranch(branch);
  }

  public List<CarDto> retrieveAllAvailableCars(Date fromDate, Date toDate){
    return carRepository.retrieveAvailableCars(fromDate, toDate).stream().map(c->carMapper.convertToDto(c)).collect(Collectors.toList());
  }

}
