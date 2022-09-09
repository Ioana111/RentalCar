import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Reservation} from "../model/reservation";
import {ActivatedRoute, Router, ParamMap, Params} from "@angular/router";
import {ReservationService} from "../reservation-service/reservation-service.service";
import {CarService} from "../car-service/car.service";
import {Car} from "../model/car";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {error} from "@angular/compiler/src/util";
import {ReservationDates} from "../model/reservationDates";


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {
  reservation: Reservation;
  selectedCar !: number;
  car!: Car;
  public reservationForm!: FormGroup;
  cars!: Car[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reservationService: ReservationService,
    private carService: CarService
  ) {
    this.reservation = new Reservation();

  }

  onSubmit() {
    this.reservationService.save(this.reservation).subscribe(result => this.goToReservationList());

  }

  goToReservationList() {
    this.router.navigate([`/reservation`]);

  }


  ngOnInit(): void {
    // New shit
    this.reservationForm = new FormGroup({
      dateFrom: new FormControl('', [Validators.required]),
      dateTo: new FormControl('', [Validators.required])
    })

    // Old shit
    this.route.params.subscribe(params => {
      this.selectedCar = params['car_id'];
    });
    // alert("Selected car:" + this.selectedCar);
    // this.carService.findCarById(this.selectedCar).subscribe(result => this.car=result);
  }

  // ngOnChanges(changes: SimpleChanges): void {
  //
  // }

  submitFormAvailableCars() {
    // alert(this.reservationForm.value.dateFrom);
    // alert(this.reservationForm.value.dateTo);
    this.carService.findAllAvailableCars(this.reservationForm.value).subscribe({
      next:(response: Car[]) => {
        this.cars = response;
        alert("it work!");
      },
      error:(errorResponse: Response) => {
        if(errorResponse.status == 400){
          alert("not work!")
        }

      }
    })
  }

}
