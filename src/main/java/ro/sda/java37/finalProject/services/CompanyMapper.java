package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CompanyDto;
import ro.sda.java37.finalProject.entities.Company;

@Service
public class CompanyMapper implements Mapper<Company, CompanyDto> {
  @Override
  public CompanyDto convertToDto(Company entity) {
    CompanyDto result = new CompanyDto();
    result.setId(entity.getId());
    result.setCompanyName(entity.getCompanyName());
    result.setOwner(entity.getOwner());
    result.setContactAddress(entity.getContactAddress());
    result.setInternetDomain(entity.getInternetDomain());
    result.setLogoType(entity.getLogoType());
    return result;
  }

  @Override
  public Company convertToEntity(CompanyDto dto) {
    Company result = new Company();
    result.setId(dto.getId());
    result.setCompanyName(dto.getCompanyName());
    result.setOwner(dto.getOwner());
    result.setContactAddress(dto.getContactAddress());
    result.setInternetDomain(dto.getInternetDomain());
    result.setLogoType(dto.getLogoType());
    return result;
  }
}
