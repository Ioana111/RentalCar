import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";
import {Car} from "../model/car";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private readonly employeeUrl: string | undefined;

  constructor(private http: HttpClient) {
    this.employeeUrl = 'http://localhost:8081/api/employee';
  }

  public findAll(): Observable<Employee[]> {
    // @ts-ignore
    return this.http.get<Employee[]>(this.employeeUrl);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(<string>this.employeeUrl, employee);
  }

  public update(employee: Employee) {
    return this.http.put<Employee>(<string>this.employeeUrl + "/{id}", employee);
  }

  public deleteEmployee(employee: Employee): Observable<Employee> {
    alert("Are you sure you want to delete " + employee.firstName +" having the id "+ employee.employeeId + "?");
    return this.http.get<Employee>(this.employeeUrl + "/delete/" + employee.employeeId);
  }

  public delete(employee: Employee) {
    return this.http.delete<Employee>(<string>this.employeeUrl + "/delete/{id}");
  }
}
