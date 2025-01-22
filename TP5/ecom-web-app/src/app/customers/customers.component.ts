import {Component, effect, inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../model/customer.model';
import {CustomerService} from '../services/customer.service';
import {Router} from '@angular/router';
import Keycloak from 'keycloak-js';
import {KEYCLOAK_EVENT_SIGNAL, KeycloakEventType, ReadyArgs, typeEventArgs} from 'keycloak-angular';

@Component({
  selector: 'app-customers',
  standalone: false,
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  public customersNotFiltred: any;
  public customers: Array<Customer> = [];
  public keyWord: string=""
  constructor(private http:HttpClient, private customerService:CustomerService, private router:Router) {}

  ngOnInit(): void {
    this.getCustomer();

  }

  getCustomer(){
    this.customerService.getCustomers().subscribe({
      next : data => {
        this.customersNotFiltred = data;
        this.customers = this.customersNotFiltred._embedded.customers; // remove embbed and to initialize list of customers directly
      },
      error : (err)=>{}
    });
  }

  deleteCustomer(p: Customer) {
    if (confirm("Est ce que vous voulez supprimer Customer "+p.name+" ???? "))
      this.customerService.deleteCustomer(p).subscribe({
      next : data => {
        let index = this.customers.indexOf(data)
        this.customers.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }

  searchCustomers() {
    let result= [];
    if(this.keyWord=="")
    {
      this.getCustomer();
    }
    for(let p of this.customers)
    {
      if(p.name.includes(this.keyWord)){
        result.push(p);
      }
    }
    this.customers = result;
  }
}
