package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.RefundDto;
import ro.sda.java37.finalProject.entities.Refund;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.RefundRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RefundService {

  RefundMapper refundMapper;
  RefundRepository refundRepository;

  public RefundDto createRefund(RefundDto refund) {
    Refund refundEntity = refundMapper.convertToEntity(refund);
    refundRepository.save(refundEntity);
    return refundMapper.convertToDto(refundEntity);
  }

  public List<RefundDto> listAllRefunds() {
    return refundRepository.findAll().stream().map(r -> refundMapper.convertToDto(r)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    refundRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified refund with %s does not exist", id)));
    refundRepository.deleteById(id);
  }

  public void updateObject(Long id, Refund refund) {
    refundRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified refund with %s does not exist", id)));
    refundRepository.save(refund);
  }

}
