package ro.sda.java37.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.RefundDto;
import ro.sda.java37.finalProject.entities.Refund;
import ro.sda.java37.finalProject.services.RefundService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/refund")
public class RefundController {

  private RefundService refundService;

  @PostMapping("/create")
  public RefundDto createRefund(@Valid RefundDto refund){
    return refundService.createRefund(refund);
  }

  @GetMapping("/list")
  public List<RefundDto> listAllRefunds(){
    return refundService.listAllRefunds();
  }

  @GetMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteRefundById(@PathVariable("id") Long id) {
    refundService.deleteById(id);
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateRefundById(@RequestBody Refund refund, @PathVariable Long id) {
    refundService.updateObject(id, refund);
  }


}
