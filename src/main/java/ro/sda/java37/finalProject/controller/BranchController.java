package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.BranchDto;
import ro.sda.java37.finalProject.entities.Branch;
import ro.sda.java37.finalProject.entities.Reservation;
import ro.sda.java37.finalProject.services.BranchService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/branch")
public class BranchController {
  private BranchService branchService;

  @PostMapping
  public BranchDto createBranch(BranchDto branch) {
    return branchService.createBranch(branch);
  }

  @GetMapping
  public List<BranchDto> listAllBranches() {
    return branchService.listAllBranches();
  }

  @GetMapping ("/delete/{id}")
  public void deleteBranchById(@PathVariable("id") Long id){
    branchService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBranchById(@RequestBody Branch branch, @PathVariable Long id) {
    branchService.updateObject(id, branch);
  }
}
