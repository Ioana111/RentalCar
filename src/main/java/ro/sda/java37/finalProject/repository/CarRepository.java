package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sda.java37.finalProject.entities.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

//    List<Car> findAllByBrand(String brand);
//    List<Car> findAllByModel(String model);
//    List<Car> findAllByBodyType(String bodyType);
//    List<Car> findAllByYear(String year);
//    @Query("SELECT c FROM Car c WHERE c.isAvailable = true")
//    List<Car> findByAvailability(@Param("isAvailable") boolean isAvailable);

  @Query(value = "SELECT c.* FROM car AS c LEFT JOIN (SELECT r.* FROM reservation AS r WHERE r.date_to >= :fromDate and r.date_from <= :toDate) AS r ON c.id = r.car_id WHERE r.car_id is null",nativeQuery = true)
//  @Query("select c from car where c.reservation
//    @Query("SELECT c from Car c join c.reservations r where r.dateFrom = ?1 and r.dateTo = ?2")
    List<Car> retrieveAvailableCars(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);






}
