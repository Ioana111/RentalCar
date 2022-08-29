import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Reservation} from "../model/reservation";
import {ActivatedRoute, Router} from "@angular/router";
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
   availableCars : Car[] | undefined;
   selectedCar : number | undefined;
  constructor(
    private route : ActivatedRoute,
    private router : Router,
    private reservationService : ReservationService,
    private carService : CarService
  ) {
    this.reservation = new Reservation ();
    carService.findAllAvailableCars().subscribe(result =>this.availableCars=result);
  }

  onSubmit (){
    this.reservationService.save(this.reservation).subscribe(result => this.goToReservationList());

  }
  goToReservationList (){
    this.router.navigate([`/reservation`]);

  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {

  }
}
