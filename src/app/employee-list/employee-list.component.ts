import {Component, OnInit} from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../employee-service/employee.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employee: Employee[] | undefined;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.findAll().subscribe(value =>
      this.employee = value)
  }

  deleteEmployee(employee: Employee) {
    this.employeeService.deleteEmployee(employee).subscribe(() => this.updateList());
  }

  updateList() {
    this.employeeService.findAll().subscribe(value => this.employee = value)
  }
}
