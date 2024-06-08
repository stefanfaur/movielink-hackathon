import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {MatToolbarModule} from "@angular/material/toolbar";
import {NgIf} from "@angular/common";
import {MatButtonModule} from "@angular/material/button";
import {NavigationService} from "./services/navigation.service";

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, MatToolbarModule, NgIf, MatButtonModule],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {
    title = 'movielink-frontend';

    constructor(private navigationService: NavigationService) {
    }

    isAuthenticated() {
        return true;
    }

  goToLogin() {
    this.navigationService.navigateToLogin();
  }

  goToRegister() {
    this.navigationService.navigateToRegister();
  }

  goToFriends() {
    this.navigationService.navigateToFriends();
  }

  goToGroups() {
    this.navigationService.navigateToGroups();
  }

}
