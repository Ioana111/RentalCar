package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.BranchDto;
import ro.sda.java37.finalProject.entities.Branch;

@Service
public class BranchMapper implements Mapper<Branch, BranchDto> {

  @Override
  public BranchDto convertToDto(Branch entity) {
    BranchDto result = new BranchDto();
    result.setId(entity.getId());
    result.setAddress(entity.getAddress());
    return result;
  }

  @Override
  public Branch convertToEntity(BranchDto dto) {
    Branch result = new Branch();
    result.setId(dto.getId());
    result.setAddress(dto.getAddress());
    return result;
  }
}
