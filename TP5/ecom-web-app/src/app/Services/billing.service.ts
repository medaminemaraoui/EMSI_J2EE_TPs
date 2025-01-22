import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Billing} from '../model/billing.model';

@Injectable({
  providedIn: 'root'
})
export class BillingService {
  public billsNotFilter: any;

  constructor(private http: HttpClient) { }

  public getBillings(): Observable<Array<Billing>>{
    return this.http.get<Array<Billing>>("http://localhost:8083/bills/All");
  }

  public getBillByCustomer(id:number): Observable<Array<Billing>>{
    return this.http.get<Array<Billing>>(`http://localhost:8083/bills/search/byCustomerId?customerId=${id}&projection=Bill`);
  }
  public getBillDetails(id:number): Observable<Billing>{
    return this.http.get<Billing>(`http://localhost:8083/bills/full/${id}`);
  }

  public addBilling(bill:Billing): Observable<Billing>{
    return this.http.post<Billing>("http://localhost:8083/bills",{bill});
  }

  public deleteBilling(bill:Billing): Observable<Billing>{
    return this.http.delete<Billing>(`http://localhost:8083/bills/${bill.id}`);
  }
}
