import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BillingService} from '../services/billing.service';
import {Billing} from '../model/billing.model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billings',
  standalone: false,
  templateUrl: './billings.component.html',
  styleUrl: './billings.component.css'
})
export class BillingsComponent implements OnInit{
  public billsNotFiltred: any;
  public bills: Array<Billing> = [];
  public customerId: number

  constructor(private http:HttpClient, private billService:BillingService, private router:Router ,private route:ActivatedRoute) {
    this.customerId = route.snapshot.params['customerId']
  }

  ngOnInit(): void {
    this.getBills()
  }

  getBills(){
    this.billService.getBillings().subscribe({
      next : data => {
        this.bills= data;
      },
      error : (err)=>{}
    });
  }

  deleteBill(bill: Billing) {
    this.billService.deleteBilling(bill).subscribe({
      next : data => {
        let index = this.bills.indexOf(data)
        this.bills.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }
}
