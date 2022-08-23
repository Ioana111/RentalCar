import {Component} from '@angular/core';
import {Employee} from "../model/employee";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../employee-service/employee.service";

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent {

  employee: Employee;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeService: EmployeeService) {
    this.employee = new Employee();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.employeService.save(this.employee).subscribe(result => this.gotoEmployeesList());
  }

  gotoEmployeesList() {
    this.router.navigate(['/employee']);
  }
}
