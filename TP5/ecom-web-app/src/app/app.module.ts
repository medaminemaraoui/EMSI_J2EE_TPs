import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {provideHttpClient} from '@angular/common/http';
import { CustomersComponent } from './customers/customers.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BillingsComponent } from './billings/billings.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';


function initializeKeycloak(keycloak: KeycloakService) {
  console.log("window location origin : "+window.location.origin)
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'ecom-realm',
        clientId: 'customer-service'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: window.location.origin + '/assets/silent-check-sso.html'
      }
    });

}

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    BillingsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    KeycloakAngularModule
  ],
  providers: [provideHttpClient(),
    {provide: APP_INITIALIZER,useFactory: initializeKeycloak, multi: true,deps: [KeycloakService] },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
