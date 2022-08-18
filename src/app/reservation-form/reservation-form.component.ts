import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Reservation} from "../model/reservation";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationService} from "../reservation/reservation-service.service";

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit, OnChanges {
   reservation : Reservation ;
  constructor(
    private route : ActivatedRoute,
    private router : Router,
    private reservationService : ReservationService
  ) {
    this.reservation = new Reservation ();
  }

  onSubmit (){
    this.reservationService.save(this.reservation).subscribe(result => this.goToReservationList());

  }
  goToReservationList (){
    this.router.navigate([`/reservations`]);

  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {

  }
}
