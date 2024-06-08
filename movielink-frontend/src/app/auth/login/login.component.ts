import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {AuthService} from "../../services/auth.service";
import {NavigationService} from "../../services/navigation.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, MatInputModule, MatButtonModule, MatCard, MatCardTitle, MatCardContent],
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private navigationService: NavigationService, private snackBar: MatSnackBar) {}

  login(): void {
    this.authService.login(this.email, this.password).subscribe(
      (response) => {
        this.authService.setToken(response.token);
        this.email = '';
        this.password = '';
        this.navigationService.navigateToFriends();
      },
      (error) => {
        this.snackBar.open('Wrong username or password. Please try again.', 'Close', {
          duration: 3000,
        });
        // wipe control values
        this.email = '';
        this.password = '';
      }
    );
  }
}
