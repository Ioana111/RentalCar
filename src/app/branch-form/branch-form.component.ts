import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Branch} from "../model/branch";
import {BranchService} from "../branch-service/branch.service";


@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css']
})
export class BranchFormComponent {

  branch: Branch;

 constructor(private route: ActivatedRoute,
             private router: Router,
             private branchService: BranchService) {
   this.branch = new Branch();
 }




  onSubmit() {
    this.branchService.save(this.branch).subscribe(result => this.gotoBranchList());
  }
  gotoBranchList() {
    this.router.navigate(['/branches']);
  }
}
