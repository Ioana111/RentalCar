import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Car} from "../model/car";
import {CustomerService} from "../customer-service/customer.service";
import {Customer} from "../model/customer";
import {HeaderComponent} from "../header/header.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'username'
  password = ''
  invalidLogin = false
  public loginForm!: FormGroup;
  customer!: Customer;
  loginCustomerLoggedIn = false;

  //show hide div variables
  userlogin = true;
  userregister = false;
  //Buttons clicks functionalities
  user_register()
  {
    this.userlogin = false;
    this.userregister = true;
  }
  user_login()
  {
    this.userlogin = true;
    this.userregister = false;
  }

  constructor(private router: Router,
              private loginService: AuthenticationService,
              private customerService:CustomerService
              ) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    })
  }


  checkLogin() {
    if (this.loginService.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['/home'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

  submitLoginForm() {
    // In backend inainte sa trebuie sa dati find byEmail si sa vedeti daca returneaza NULL
    this.customerService.loginCustomer(this.loginForm.value.email,
      this.loginForm.value.password)
      .subscribe({
        next:(response: Customer) => {
          this.customer = response;
          this.loginCustomerLoggedIn = true;
          this.router.navigate(['/home']);
        },
        error:(errorResponse: Response) => {
          if(errorResponse.status == 400){
            alert("Username or password are not valid!")
          }
        }
      })

  }

}
