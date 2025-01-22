import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-customers',
  standalone: false,

  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers : any;
  constructor(private http:HttpClient) { }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/CUSTOMER-SERVICE/customers?projection=fullCustomer").subscribe({
      next : (data) => {
        this.customers = data;
      },
      error : (err)=>{}
    });
  }
}
