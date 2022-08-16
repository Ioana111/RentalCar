package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.LoanDto;
import ro.sda.java37.finalProject.entities.Loan;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.LoanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanService {
  private LoanMapper loanMapper;
  private LoanRepository loanRepository;

  public LoanDto createLoan(LoanDto loan) {
    Loan loanEntity = loanMapper.convertToEntity(loan);
    loanRepository.save(loanEntity);
    return loanMapper.convertToDto(loanEntity);
  }

  public List<LoanDto> listAllLoans() {
    return loanRepository.findAll().stream()
      .map(l -> loanMapper.convertToDto(l)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    loanRepository.findById(id).orElseThrow(
      () -> new EntityNotFoundError(String.format("Specified loan with %s was not found", id)));
    loanRepository.deleteById(id);
  }

  public void updateById(Long id, LoanDto loan) {
    Loan result = loanRepository.findById(id).orElseThrow(
      () -> new EntityNotFoundError(String.format("Specified loan with %s was not found", id)));
    result.setId(loan.getId());
    result.setComments(loan.getComments());
    result.setDateOfRental(loan.getDateOfRental());
    loanRepository.save(result);
  }
}
