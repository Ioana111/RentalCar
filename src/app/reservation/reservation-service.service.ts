import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reservation } from '../model/reservation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root'
  }
)
export class ReservationService {

  private readonly reservationsUrl: string ;

  constructor(private http: HttpClient) {
    this.reservationsUrl = 'http://localhost:8081/api/reservations';
  }

  public findAll(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.reservationsUrl);
  }

  public save(reservation: Reservation) {
    return this.http.post<Reservation>(this.reservationsUrl, reservation);
  }
  public update (reservation : Reservation){
    return this.http.put<Reservation> (<string>this.reservationsUrl + "/{id}" , reservation);
  }
  public deleteReservation (reservation:Reservation):Observable <Reservation> {
    alert ("Rezervarea s-a sters!" + reservation.id);
    return this.http.get<Reservation> (this.reservationsUrl + "/delete/ " + reservation.id);
  }

}
