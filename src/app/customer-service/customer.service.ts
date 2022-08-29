import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private readonly customerUrl: string | undefined;

  constructor(private http: HttpClient) {
    this.customerUrl = 'http://localhost:8081/api/customer';
  }

  public findAll(): Observable<Customer[]> {
    // @ts-ignore
    return this.http.get<Customer[]>(this.customerUrl);
  }

  public save(customer: Customer) {
    alert(customer.firstName + ' ' + customer.lastName + ' ' + customer.email);
    return this.http.post<Customer>(<string>this.customerUrl, customer);
  }

  public update(customer: Customer) {
    return this.http.put<Customer>(<string>this.customerUrl + "/{id}", customer);
  }

  public deleteCustomer(customer: Customer): Observable<Customer> {
    alert("Are you sure you want to delete " + customer.firstName + " having the id " + customer.id + "?");
    return this.http.get<Customer>(this.customerUrl + "/delete/" + customer.id);
  }

  public delete(customer: Customer) {
    return this.http.delete<Customer>(<string>this.customerUrl + "/delete/{id}");
  }
}
