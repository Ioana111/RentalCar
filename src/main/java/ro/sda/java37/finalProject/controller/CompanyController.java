package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CompanyDto;
import ro.sda.java37.finalProject.entities.Company;
import ro.sda.java37.finalProject.services.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/company/")
public class CompanyController {

  private CompanyService companyService;

  @PostMapping
  public CompanyDto createCompany(@RequestBody CompanyDto company) {
    return companyService.createCompany(company);
  }

  @GetMapping
  public List<CompanyDto> listAllCompanies() {
    return companyService.listAllCompanyes();
  }

  @GetMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCompanyById(@PathVariable("id") Long id) {
    companyService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCompanyById(@RequestBody @Valid CompanyDto company, @PathVariable Long id) {
    companyService.updateByID(id, company);
  }
}
