import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Reservation} from "../model/reservation";
import {ActivatedRoute, Router, ParamMap, Params} from "@angular/router";
import {ReservationService} from "../reservation-service/reservation-service.service";
import {CarService} from "../car-service/car.service";
import {Car} from "../model/car";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {error} from "@angular/compiler/src/util";
import {ReservationDates} from "../model/reservation-dates";


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

  availableCars: Car[] | undefined;

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
    // this.route.params.subscribe(params => {
    //   this.selectedCar = params['car_id'];
    // });

    // alert("Selected car:" + this.selectedCar);
    // this.carService.findCarById(this.selectedCar).subscribe(result => this.car=result);
  }

  // ngOnChanges(changes: SimpleChanges): void {
  //
  // }


  submitFormAvailableCars() {
    // alert(this.reservationForm.value.dateFrom);
    // alert(this.reservationForm.value.dateTo);
    //let formObject = this.reservationForm.getRawValue();
    //let serializedForm = JSON.stringify(this.reservationForm.value);

    this.carService.findAllAvailableCars(this.reservationForm.value.dateFrom,
      this.reservationForm.value.dateTo)
      .subscribe({
      next:(response: Car[]) => {
        this.availableCars = response;

        this.router.navigate([`/cars`],{ queryParams:{prop: JSON.stringify(this.availableCars)}});
      },
      error:(errorResponse: Response) => {
        if(errorResponse.status == 400){
          alert("not work!")
        }
      }
    })

  }

}
