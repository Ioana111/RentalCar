package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CustomerDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Customer;
import ro.sda.java37.finalProject.services.CustomerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/addNewCustomer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/findAll")
    public List<CustomerDto> listAllCustomers() {
        return customerService.listAllCustomers();

    }

    @GetMapping ("/delete/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id){
      customerService.deleteById(id);
    }

  @PutMapping("/api/reservation/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCustomerById(@RequestBody Customer customer, @PathVariable Long id) {
    customerService.updateCustomer(id, customer);
  }
}
