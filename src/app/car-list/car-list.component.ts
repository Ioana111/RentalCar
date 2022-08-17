import { Component, OnInit } from '@angular/core';
import {Car} from "../model/car";
import {CarService} from "../car-service/car.service";
import {ActivatedRoute,Router} from "@angular/router";

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  car: Car[] | undefined;



  constructor(private carService: CarService){}



ngOnInit() {
    this.carService.findAll().subscribe(data => {
      this.car=data;
    });
}
deleteCar(car: Car){
    alert(car.id);
    this.carService.deleteCar(car).subscribe(data=>this.updateList());
}

updateList(){
  this.carService.findAll().subscribe(data => {
    this.car=data;
  });
}

}
