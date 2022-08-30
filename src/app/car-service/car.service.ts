import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../model/car";
import {Reservation} from "../model/reservation";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private readonly carsUrl: string | undefined;

  reservation!: Reservation;


  constructor(private http: HttpClient) {
    this.carsUrl = 'http://localhost:8081/api/car';
  }

  public findAll(): Observable<Car[]> {
    // @ts-ignore
    return this.http.get<Car[]>(this.carsUrl);
  }

  public findAllAvailableCars(): Observable<Car[]>{

    return this.http.get<Car[]>(this.carsUrl + "/availability");
  }

  public findCarById(carId: Number): Observable<Car>{
    return this.http.get<Car>(this.carsUrl+"/"+carId);
  }


  public save(car: Car) {
    return this.http.post<Car>(<string>this.carsUrl, car);
  }

  public update(car: Car) {
    return this.http.put<Car>(<string>this.carsUrl + "/{id}", car);
  }

  public deleteCar(car: Car): Observable<Car> {
    alert("Are you sure you want to delete " + car.brand +" having the id "+ car.id + "?");

    return this.http.get<Car>(this.carsUrl + "/delete/" + car.id);
  }

  public delete(car: Car) {
    return this.http.delete<Car>(<string>this.carsUrl + "/delete/{id}");
  }


}





