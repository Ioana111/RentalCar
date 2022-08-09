package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java37.finalProject.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
