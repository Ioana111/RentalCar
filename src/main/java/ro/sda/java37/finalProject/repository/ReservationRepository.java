package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    @Query("UPDATE Reservation r SET r.dateTo=:dateTo, r.returnBranch=:returnBranch WHERE r.id=: id ")
//    void updateById(@Param("id")Long id,@Param("dateTo") Date dateTo,@Param("returnBranch") Branch returnBranch);





}
