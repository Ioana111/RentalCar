import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CarListComponent} from './car-list/car-list.component';
import {CarFormComponent} from './car-form/car-form.component';
import {ReservationListComponent} from "./reservation-list/reservation-list.component";
import {ReservationFormComponent} from "./reservation-form/reservation-form.component";
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeFormComponent} from "./employee-form/employee-form.component";
import {BranchListComponent} from "./branch-list/branch-list.component";
import {BranchFormComponent} from "./branch-form/branch-form.component";
import {CustomerFormComponent} from "./customer-form/customer-form.component";
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {RefundListComponent} from "./refund-list/refund-list.component";
import {RefundFormComponent} from "./refund-form/refund-form.component";
import {HomeComponent} from "./home/home.component";
import {AdminComponent} from "./admin/admin.component";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";
import {AuthGuardService} from "./service/auth-guard.service";
import {SignUpComponent} from "./sign-up/sign-up.component";

const routes: Routes = [
  { path: 'home', component:HomeComponent},
  { path: 'admin', component:AdminComponent},
  { path: 'cars', component: CarListComponent },
  { path: 'add-car', component: CarFormComponent },
  { path: 'reservations', component: ReservationListComponent },
  { path: 'add-reservation/:car_id', component: ReservationFormComponent },
  { path: 'employee', component: EmployeeListComponent},
  { path: 'add-employees', component: EmployeeFormComponent},
  { path: 'branch', component:BranchListComponent},
  { path: 'add-branches', component: BranchFormComponent},
  { path: 'add-customer', component: CustomerFormComponent, canActivate:[AuthGuardService] },
  { path: 'customers', component: CustomerListComponent},
  { path: 'refund', component: RefundListComponent},
  { path: 'add-refund', component: RefundFormComponent},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component:LogoutComponent, canActivate:[AuthGuardService]},
  { path: 'sign-up', component:SignUpComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
