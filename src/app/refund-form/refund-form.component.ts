import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Refund} from "../model/refund";
import {RefundService} from "../refund-service/refund.service";

@Component({
  selector: 'app-refund-form',
  templateUrl: './refund-form.component.html',
  styleUrls: ['./refund-form.component.css']
})
export class RefundFormComponent implements OnInit, OnChanges{

  refund: Refund;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private refundService: RefundService) {
    this.refund = new Refund();
  }


  onSubmit() {
    this.refundService.save(this.refund).subscribe(result => this.goToRefundList());
  }

  goToRefundList() {
    this.router.navigate(['/refunds']);
  }
  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {

  }

}
