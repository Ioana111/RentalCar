package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Reservation;

import javax.persistence.criteria.Join;
import java.math.BigDecimal;
import java.util.List;

public interface BranchRepository extends JpaRepository <Branch, Long> {

  @Query(value = "select sum(r.total_amount), b.* from car c inner join reservation r on c.id=r.car_id inner join branch b on c.branch_id = b.id group by branch_of_loan_id", nativeQuery = true)
  List<Branch> retriveProfitabilityPerBranch();



}
