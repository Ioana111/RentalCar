package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.RefundDto;
import ro.sda.java37.finalProject.entities.Refund;

@Service
public class RefundMapper implements Mapper<Refund, RefundDto>{

  @Override
  public RefundDto convertToDto(Refund entity) {
    RefundDto result = new RefundDto();
    result.setId(entity.getId());
    result.setDateOfReturn(entity.getDateOfReturn());
    result.setSurcharge(entity.getSurcharge());
    result.setComments(entity.getComments());
    return result;
  }

  @Override
  public Refund convertToEntity(RefundDto dto) {
    Refund result = new Refund();
    result.setId(dto.getId());
    result.setDateOfReturn(dto.getDateOfReturn());
    result.setSurcharge(dto.getSurcharge());
    result.setComments(dto.getComments());
    return result;
  }

}
