package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.LoanDto;
import ro.sda.java37.finalProject.entities.Loan;

@Service
public class LoanMapper implements Mapper<Loan, LoanDto> {
  @Override
  public LoanDto convertToDto(Loan entity) {
    LoanDto result = new LoanDto();
    result.setId(entity.getId());
    result.setComments(entity.getComments());
    result.setDateOfRental(entity.getDateOfRental());
    return result;
  }

  @Override
  public Loan convertToEntity(LoanDto dto) {
    Loan result = new Loan();
    result.setId(dto.getId());
    result.setComments(dto.getComments());
    result.setDateOfRental(dto.getDateOfRental());
    return null;
  }
}
