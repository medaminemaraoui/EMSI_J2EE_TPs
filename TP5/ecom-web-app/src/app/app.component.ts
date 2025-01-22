import {Component, OnInit} from '@angular/core';
import {KeycloakProfile} from 'keycloak-js';
import {KeycloakService} from 'keycloak-angular';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'ecom-web-app';
  public profile!: KeycloakProfile;
  navbarItems: Array<any> = [
    { title:"products", "route":"/products", icon:"house", role:"ADMIN"},
    { title:"customers", "route":"/customers", icon:"people", role:"USER"},
    { title:"Billing", "route":"/billing", icon:"receipt-cutoff", role:"USER"}
  ];
  currentAction : any;


  constructor(public keycloakService: KeycloakService, private router: Router) {
  }



  ngOnInit() {
    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then(profile=>{
        this.profile=profile;
      });
    }
    // Écouter la navigation pour détecter le chemin /logout
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd && event.url === '/logout') {
        this.handlelogout();
      }
    });
  }

  setCurrentAction(item: any) {
    this.currentAction = item
  }

  async handlelogin() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }

  handlelogout() {
    this.keycloakService.logout(window.location.origin);
    // this.keycloakService.logout();
  }
}
