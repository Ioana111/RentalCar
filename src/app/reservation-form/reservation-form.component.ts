import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Reservation} from "../model/reservation";
import {ActivatedRoute, Router, ParamMap,Params} from "@angular/router";
import {ReservationService} from "../reservation-service/reservation-service.service";
import {CarService} from "../car-service/car.service";
import {Car} from "../model/car";


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit, OnChanges {
   reservation : Reservation ;
   selectedCar !: number ;
   car!: Car;
  constructor(
    private route : ActivatedRoute,
    private router : Router,
    private reservationService : ReservationService,
    private carService : CarService,
  ) {
    this.reservation = new Reservation ();

  }

  onSubmit (){
    this.reservationService.save(this.reservation).subscribe(result => this.goToReservationList());

  }
  goToReservationList (){
    this.router.navigate([`/reservation`]);

  }


  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      this.selectedCar= params['car_id'];
    });
   // alert("Selected car:" + this.selectedCar);
    // this.carService.findCarById(this.selectedCar).subscribe(result => this.car=result);
  }

  ngOnChanges(changes: SimpleChanges): void {

  }
}
