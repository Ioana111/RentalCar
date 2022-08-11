package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.dto.CustomerDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Customer;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerDto createCustomer(CustomerDto customer) {
        Customer customerEntity= customerMapper.convertToEntity(customer);
        customerRepository.save(customerEntity);
        return customerMapper.convertToDto(customerEntity);
    }

    public List<CustomerDto> listAllCustomers() {
        return customerRepository.findAll().stream().map(c-> customerMapper.convertToDto(c)).collect(Collectors.toList());
    }

    public void deleteById(Long id){
      customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified customer does not exist", id)));
      customerRepository.deleteById(id);
    }

  public void updateCustomer(Long id, Customer customer) {
    customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified custoomer with %s does not exist", id)));
    customerRepository.save(customer);
  }
}
