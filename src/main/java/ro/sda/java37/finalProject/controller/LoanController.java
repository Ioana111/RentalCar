package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.LoanDto;
import ro.sda.java37.finalProject.services.LoanService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/loan")
public class LoanController {
  private LoanService loanService;

  @PostMapping
  public LoanDto createLoan(@RequestBody LoanDto loan) {
    return loanService.createLoan(loan);
  }

  @GetMapping
  public List<LoanDto> listAllLoans() {
    return loanService.listAllLoans();
  }

  @GetMapping("delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable("id") Long id) {
    loanService.deleteById(id);
  }

  @GetMapping("update/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateById(@RequestBody LoanDto loan, @PathVariable("id") Long id) {
    loanService.updateById(id, loan);
  }

}
