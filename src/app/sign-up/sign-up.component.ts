import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer-service/customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  customerSignUpForm!: FormGroup;

  constructor( private customerService:CustomerService){

  }

  ngOnInit(): void {
    this.customerSignUpForm = new FormGroup({
      firstName: new FormControl('',[Validators.required]),
      lastName: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    })
  }
  submitFormData(){
    this.customerService.save(this.customerSignUpForm.value).subscribe(data =>{
      console.log("Registration successful")
    })
  }

}
