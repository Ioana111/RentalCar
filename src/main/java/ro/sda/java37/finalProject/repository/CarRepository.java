package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sda.java37.finalProject.entities.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.brand = :brand")
    List<Car> findByBrand(@Param("brand") String brand);

    @Query("SELECT c FROM Car c WHERE c.model = :model")
    List<Car> findByModel(@Param("model") String model);

    @Query("SELECT c FROM Car c WHERE c.bodyType = :bodyType")
    List<Car> findByBodyType(@Param("bodyType") String bodyType);

    @Query("SELECT c FROM Car c WHERE c.year = :year")
    List<Car> findByYear(@Param("year") int year);

    @Query("SELECT c FROM Car c WHERE c.color = :color")
    List<Car> findByColor(@Param("color") String color);

    @Query("SELECT c FROM Car c WHERE c.isAvailable = true")
    List<Car> findByAvailability(@Param("isAvailable") boolean isAvailable);





}
