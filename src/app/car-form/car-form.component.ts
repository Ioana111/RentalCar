import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Car} from "../model/car";
import {CarService} from "../car-service/car.service";

@Component({
  selector: 'app-car-form',
  templateUrl: './car-form.component.html',
  styleUrls: ['./car-form.component.css']
})
export class CarFormComponent {

  car: Car;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private carService: CarService) {
    this.car = new Car();
  }

  onSubmit() {
    this.carService.save(this.car).subscribe(result => this.gotoCarList());
  }

  gotoCarList() {
    this.router.navigate(['/cars']);
  }


}
