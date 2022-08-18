import { Component, OnInit } from '@angular/core';
import { Reservation} from "../model/reservation";
import { ReservationService} from "../reservation/reservation-service.service";
import { ActivatedRoute , Router} from "@angular/router";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
reservation: Reservation [] | undefined;

  constructor(private reservationService : ReservationService)  { }

  ngOnInit() {

    this.reservationService.findAll().subscribe(data => {
      this.reservation=data;
    });
  }
  deleteReservation(reservation: Reservation){
    alert(reservation.id);
    this.reservationService.deleteReservation(reservation).subscribe(data=>this.updateList());
  }

  updateList(){
    this.reservationService.findAll().subscribe(data => {
      this.reservation=data;
    });
  }

}
