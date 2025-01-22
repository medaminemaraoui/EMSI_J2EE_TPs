import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {BillingsComponent} from './billings/billings.component';
import {AuthGuard} from './guards/auth.guard';

const routes: Routes = [
  { path : "products", component : ProductsComponent,  canActivate: [AuthGuard],data: {roles:['ADMIN']}  },
  { path : "customers", component : CustomersComponent,canActivate: [AuthGuard],data: {roles:['USER']} },
  { path : "billing", component : BillingsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
