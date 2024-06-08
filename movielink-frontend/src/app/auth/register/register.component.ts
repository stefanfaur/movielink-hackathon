import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {NavigationService} from "../../services/navigation.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AuthService} from "../../services/auth.service";
import {PasswordValidatorDirective} from "../directives/password.directive";
import {FullNameValidatorDirective} from "../directives/full-name.directive";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    PasswordValidatorDirective,
    FullNameValidatorDirective,
  ],
})
export class RegisterComponent {
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  fullName: string = '';
  passwordsMatch: boolean = true;

  constructor(private authService: AuthService, private navigationService: NavigationService, private router: Router, private snackBar: MatSnackBar) {}

  register(form: NgForm): void {
    this.passwordsMatch = this.password === this.confirmPassword;

    if (form.valid && this.passwordsMatch) {
      this.authService.register(this.email, this.password, this.fullName).subscribe(
        (response) => {
          this.navigationService.navigateToLogin();
        },
        (error) => {
          this.snackBar.open('Register failed.', 'Close', {
            duration: 3000,
          });
        }
      );
    } else {
      this.snackBar.open('Passwords do not match.', 'Close', {
        duration: 3000,
      });
    }
  }
}
