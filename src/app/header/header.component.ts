import {Component, Input, OnInit} from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // @Input() login!: LoginComponent
  loginService: any;
  customerLoggedIn: boolean = false;

  constructor(private login:LoginComponent) { }


  ngOnInit() {
    this.customerLoggedIn = this.login.loginCustomerLoggedIn;

    // if(this.userLoggedIn){
    //
    // }
  }




}
