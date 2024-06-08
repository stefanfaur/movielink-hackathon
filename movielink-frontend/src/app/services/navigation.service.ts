import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class NavigationService {

  constructor(private router: Router) { }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }

  navigateToRegister() {
    this.router.navigate(['/register']);
  }

  navigateToFriends() {
    this.router.navigate(['/friends']);
  }

  navigateToGroups() {
    this.router.navigate(['/groups']);
  }

  navigateToGroup(id: number) {
    this.router.navigate(['/groups', id]);
  }

  navigateToProfile() {
    this.router.navigate(['/profile']);
  }
}
