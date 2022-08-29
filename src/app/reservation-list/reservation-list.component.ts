import { Component, OnInit } from '@angular/core';
import { Reservation} from "../model/reservation";
import { ReservationService} from "../reservation-service/reservation-service.service";
import { ActivatedRoute , Router} from "@angular/router";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
reservations: Reservation [] | undefined;

  constructor(private reservationService : ReservationService)  { }

  ngOnInit() {

    this.reservationService.findAll().subscribe(data => {
      this.reservations=data;
    });
  }
  deleteReservation(reservation: Reservation){
    alert(reservation.id);
    this.reservationService.deleteReservation(reservation).subscribe(data=>this.updateList());
  }

  updateList(){
    this.reservationService.findAll().subscribe(data => {
      this.reservations=data;
    });
  }

}
