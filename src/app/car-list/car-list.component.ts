import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {Car} from "../model/car";
import {CarService} from "../car-service/car.service";
import {ReservationFormComponent} from "../reservation-form/reservation-form.component";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  availableCarsList: Car[] | undefined;

  car: Car[] | undefined;


  constructor(private carService: CarService,
              private route: ActivatedRoute,
              private router: Router) {
  }


  // ngAfterViewInit(): void {
  //   this.availableCarsList = this.reservationForm?.availableCars;
  //   alert(this.availableCarsList);
  // }

  ngOnInit() {
    //this.showAllCars()\

      this.route.queryParams.subscribe(params => {
        this.availableCarsList = JSON.parse(params['prop']);
      }).unsubscribe();
    //this.availableCarsList=  JSON.parse(params['prop']);
  }

// this.carService.findAll().subscribe(data => {
//   this.car = data;
// });


  showAllCars() {
    this.carService.findAll().subscribe(data => {
      this.availableCarsList = data;
    });
  }

  deleteCar(car
              :
              Car
  ) {
    this.carService.deleteCar(car).subscribe(data => this.updateList());
  }

  updateList() {
    this.carService.findAll().subscribe(data => {
      this.car = data;
    });
  }


}
