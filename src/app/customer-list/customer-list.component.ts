import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../customer-service/customer.service";
import {Customer} from "../model/customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customer: Customer[] | undefined;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customer = data;
    })
  }
  deleteCustomer(customer: Customer){
    this.customerService.deleteCustomer(customer).subscribe(data=>this.updateList());
  }

  updateList(){
    this.customerService.findAll().subscribe(data => {
      this.customer=data;
    });
  }
}
