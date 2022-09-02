package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.BranchDto;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.BranchRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BranchService {
  BranchMapper branchMapper;
  BranchRepository branchRepository;

  public BranchDto createBranch(BranchDto branch){
    Branch branchEntity=branchMapper.convertToEntity(branch);
    branchRepository.save(branchEntity);
    return branchMapper.convertToDto(branchEntity);
  }

  public List<BranchDto> listAllBranches(){
    return branchRepository.findAll().stream().map(branch -> branchMapper.convertToDto(branch)).collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    branchRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified branch with %s does not exist", id)));
    branchRepository.deleteById(id);
  }

  public void updateObject(Long id, BranchDto branchDto) {
    Branch entity=branchRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Specified branch with %s does not exist", id)));
    entity.setId(branchDto.getId());
    entity.setAddress(branchDto.getAddress());
    branchRepository.save(entity);
  }

  public List<BranchDto> listBranchByProfitability(){
    return branchRepository.retriveProfitabilityPerBranch().stream().map(branch-> branchMapper.convertToDto(branch)).collect(Collectors.toList());
  }



}
