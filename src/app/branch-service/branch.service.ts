import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Branch} from "../model/branch";

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  private readonly branchUrl: string | undefined;

  constructor(private http: HttpClient) {
    this.branchUrl = 'http://localhost:8081/api/branch';

  }

  public findAll(): Observable<Branch[]> {
    // @ts-ignore
    return this.http.get<Branch[]>(this.branchUrl);
  }

  public save(branch: Branch) {
    return this.http.post<Branch>(<string>this.branchUrl, branch);
  }

  public update(branch: Branch) {
    return this.http.put<Branch>(<string>this.branchUrl + "/{id}", branch);
  }

  public deleteBranch(branch: Branch): Observable<Branch> {
    alert("Are you sure you want to delete " + branch.address + " having the id " + branch.id + "?");
    return this.http.get<Branch>(this.branchUrl + "/delete/" + branch.id);
  }

  public delete(branch: Branch) {
    return this.http.delete<Branch>(<string>this.branchUrl + "/delete/{id}");
  }
}


