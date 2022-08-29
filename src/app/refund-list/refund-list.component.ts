import {Component, OnInit} from '@angular/core';
import {Refund} from "../model/refund";
import {RefundService} from "../refund-service/refund.service";

@Component({
  selector: 'app-refund-list',
  templateUrl: './refund-list.component.html',
  styleUrls: ['./refund-list.component.css']
})
export class RefundListComponent implements OnInit {
refund: Refund [] | undefined;

  constructor(private refundService : RefundService)  { }

  ngOnInit() {

    this.refundService.findAll().subscribe(data => {
      this.refund=data;
    });
  }
  deleteRefund(refund: Refund){
    alert(refund.id);
    this.refundService.deleteRefund(refund).subscribe(data=>this.updateList());
  }

  updateList(){
    this.refundService.findAll().subscribe(data => {
      this.refund=data;
    });
  }


}
