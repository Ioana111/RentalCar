package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CustomerDto;
import ro.sda.java37.finalProject.services.CustomerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping()
    public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<CustomerDto> listAllCustomers() {
        return customerService.listAllCustomers();
    }
}
