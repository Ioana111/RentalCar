import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Refund} from "../model/refund";

@Injectable({
  providedIn: 'root'
})
export class RefundService {

  private readonly refundUrl: string | undefined;


  constructor(private http: HttpClient) {
    this.refundUrl = 'http://localhost:8081/api/refunds';
  }

  public findAll(): Observable<Refund[]> {
    // @ts-ignore
    return this.http.get<Refund[]>(this.refundUrl);
  }

  public save(refund: Refund) {
    return this.http.post<Refund>(<string>this.refundUrl, refund);
  }

  public update(refund: Refund) {
    return this.http.put<Refund>(<string>this.refundUrl + "/{id}", refund);
  }

  public deleteRefund(refund: Refund): Observable<Refund> {
    alert("Are you sure you want to delete "+ refund.id + "?");

    return this.http.get<Refund>(this.refundUrl + "/delete/" + refund.id);
  }

  public delete(refund: Refund) {
    return this.http.delete<Refund>(<string>this.refundUrl + "/delete/{id}");
  }
}





