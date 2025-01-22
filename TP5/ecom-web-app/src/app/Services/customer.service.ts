import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  public getCustomers(): Observable<Array<Customer>>{
    return this.http.get<Array<Customer>>("http://localhost:8081/customers?projection=fullCustomer");
  }

  public addCustomer(customer:Customer): Observable<Customer>{
    return this.http.post<Customer>("http://localhost:8081/customers",{customer});
  }

  public deleteCustomer(customer:Customer): Observable<Customer>{
    return this.http.delete<Customer>(`http://localhost:8081/customers/${customer.id}`);
  }
}
