import { Component, OnInit } from '@angular/core';
import {Branch} from "../model/branch";
import {BranchService} from "../branch-service/branch.service";
import {Car} from "../model/car";

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css']
})
export class BranchListComponent implements OnInit {
  branch: Branch[] | undefined;

  constructor(private branchService: BranchService) {
  }

  ngOnInit() {
    this.branchService.findAll().subscribe(data => {
      this.branch = data;
    });
  }

  deleteBranch(branch: Branch) {
    this.branchService.deleteBranch(branch).subscribe(data => this.updateList());
  }

  updateList() {
    this.branchService.findAll().subscribe(data => {
      this.branch = data;
    });
  }
}
