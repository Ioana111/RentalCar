import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../model/car";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private readonly carsUrl: string | undefined;


  constructor(private http: HttpClient) {
    this.carsUrl = 'http://localhost:8081/api/car';
  }

  public findAll(): Observable<Car[]> {
    // @ts-ignore
    return this.http.get<Car[]>(this.carsUrl);
  }

  public save(car: Car) {
    return this.http.post<Car>(<string>this.carsUrl, car);
  }
}

