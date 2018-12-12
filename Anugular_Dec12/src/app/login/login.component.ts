import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { RouterService } from '../services/router.service';
import { Response } from '@angular/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  submitMessage: string;
  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required, Validators.minLength(8)]);

  constructor(private authService: AuthenticationService,
    private routerService: RouterService) {
    this.submitMessage = '';
  }

  loginSubmit() {
    if (this.username != null && this.password != null) {
      this.authService.authenticateUser({ 'username': this.username.value, 'password': this.password.value }).subscribe(
        data => {
          if (data[0].m_sLoginStatusMsg == 'ValidUser') {
            console.log("Valid data");
            console.log("authenticateUser: " + data[0].m_sLoginStatusMsg);
            this.authService.setBearerToken(data[0].m_sHeaderToken);
            console.log("Token: " + data[0].m_sHeaderToken);
            //this.authService.setIslogin(true);
            localStorage.setItem('isLogin', 'true');
            this.routerService.routeToHome();
          } else {
            console.log("InValid data");
            //this.submitMessage = data[0].m_sHeaderToken;
            this.authService.loginFailure();
            this.submitMessage = 'Please provide valid credential!';
            this.routerService.routeToLogin();
          }
        }, error => {
          alert("Something went Wrong")
        }
      );
    }
  }

  validateUserName() {
    return this.username.hasError('required') ? 'User Name is Required' : '';
  }

  validatePassword() {
    return this.password.hasError('required') ? 'Password is Required' : '';
  }

  checkPasswordLength() {
    return this.password.hasError('minlength') ? 'Minimum Password length should be 8' : '';
  }

  handleErrorResponse(error: HttpErrorResponse): void {
    if (error.status === 404) {
      this.submitMessage = `Http failure response for ${error.url}: 404 Not Found`;
    } else {
      this.submitMessage = error.error.message;
    }

  }
}
