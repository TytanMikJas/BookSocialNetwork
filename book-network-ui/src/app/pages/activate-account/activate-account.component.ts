import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss'
})
export class ActivateAccountComponent {
  message: string = '';
  isOkay: boolean = true;
  submitted: boolean = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
  ) {}

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }

  redirectToLogin() {
    this.router.navigate(['login'])
  }

  private confirmAccount(token: string) {
    this.authService.confirm({
      token
    }).subscribe({
      next: () => {
        this.message = 'Account activated successfully\nProceed to login';
        this.submitted = true;
        this.isOkay = true;
      },
      error: (error) => {
        this.message = 'Token has been expired or invalid\nA new token has been sent to your email address\nPlease try again'
        this.submitted = true;
        this.isOkay = false;
      }
    })
  }
}
