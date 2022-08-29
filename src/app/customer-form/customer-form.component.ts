import {Component} from '@angular/core';
import {Customer} from "../model/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../customer-service/customer.service";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent  {

  customer: Customer;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private customerService: CustomerService) {
    this.customer = new Customer();
  }

  onSubmit() {
    alert(this.customer);
    this.customerService.save(this.customer).subscribe(result => this.gotoCustomerList());
  }

  gotoCustomerList() {
    this.router.navigate(['/add-customer']);
  }

}
