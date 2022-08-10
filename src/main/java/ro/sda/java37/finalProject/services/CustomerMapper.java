package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CustomerDto;
import ro.sda.java37.finalProject.entities.Customer;

@Service
public class CustomerMapper implements Mapper<Customer, CustomerDto> {


    @Override
    public CustomerDto convertToDto(Customer entity) {
        CustomerDto result = new CustomerDto();
        result.setId(entity.getId());
        result.setFirstName(entity.getFirstName());
        result.setLastName(entity.getLastName());
        result.setAddress(entity.getAddress());
        result.setEmail(entity.getEmail());
        return result;
    }

    @Override
    public Customer convertToEntity(CustomerDto dto) {
        Customer result = new Customer();
        result.setId(dto.getId());
        result.setFirstName(dto.getFirstName());
        result.setLastName(dto.getLastName());
        result.setAddress(dto.getAddress());
        result.setEmail(dto.getEmail());
        return result;
    }
}
