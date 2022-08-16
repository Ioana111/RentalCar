package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CarDto;
import ro.sda.java37.finalProject.dto.CompanyDto;
import ro.sda.java37.finalProject.entities.Car;
import ro.sda.java37.finalProject.entities.Company;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {
  CompanyMapper companyMapper;
  CompanyRepository companyRepository;

  public CompanyDto createCompany(CompanyDto company) {
    Company companyEntity = companyMapper.convertToEntity(company);
    companyRepository.save(companyEntity);
    return companyMapper.convertToDto(companyEntity);
  }

  public List<CompanyDto> listAllCompanyes() {
    return companyRepository.findAll().stream()
      .map(company -> companyMapper.convertToDto(company)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified company with %s does not exist", id)));
    companyRepository.deleteById(id);
  }

  public void updateByID(Long id, CompanyDto company) {
    Company result = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified company with %s does not exist", id)));
    result.setId(company.getId());
    result.setCompanyName(company.getCompanyName());
    result.setOwner(company.getOwner());
    result.setContactAddress(company.getContactAddress());
    result.setInternetDomain(company.getInternetDomain());
    result.setLogoType(company.getLogoType());
    companyRepository.save(result);
  }
}
