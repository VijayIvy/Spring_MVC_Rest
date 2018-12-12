import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { BehaviorSubject } from 'rxjs';
import { RouterService } from '../services/router.service'

@Injectable()
export class AuthenticationService {
  baseUrl = 'http://10.219.203.183:8080/NMJML/authenticateUser';
  getUnitDetailsUrl = 'http://localhost:8080/NMJML/getUnitDetails';
  getSubUnitDetailsUrl = 'http://localhost:8080/NMJML/getSubUnitDetails';
  authTokenName: any;
  private loggedIn = new BehaviorSubject<boolean>(this.tokenAvailable());
  private tokenAvailable(): boolean {
  return !!localStorage.getItem('vToken');
 } 
  get isLoggedIn() {
    return this.loggedIn.asObservable(); 
   }

  constructor(private httpClient: HttpClient, private routerService: RouterService) { }

  authenticateUser(data) {
    console.log("Service authenticateUser" + data);
    let resource = JSON.stringify(data);
    this.loggedIn.next(true);
    console.log("resource" + resource);
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    headers = headers.set('Authorization', 'No Need');
    console.log('Headers2: ' + headers.get('Content-Type') + ' Authorization: ' + headers.get('Authorization'));
    return this.httpClient.post(`${this.baseUrl}`, resource, { headers });
  }

  setBearerToken(token) {
    console.log("token: " + token);
    localStorage.setItem(this.authTokenName, token);
    localStorage.setItem('vToken', token);
    console.log("setBearerToken: " + localStorage.getItem('vToken'));
    console.log("authTokenName: " + localStorage.getItem(this.authTokenName));
    //localStorage.setItem('isLogin', 'true');
  }

  getBearerToken() {
    console.log("getBearerToken");
    return localStorage.getItem(this.authTokenName);
  }

  isUserAuthenticated(token): Promise<boolean> {
    console.log("isUserAuthenticated" + token);
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.httpClient.post(`${this.baseUrl}isAuthenticated`, {}, { headers })
      .map(res => res['isAuthenticated'])
      .toPromise();
  }

  // isLogin: boolean;

  // setIslogin(isLogin: boolean) {
  //   this.isLogin = isLogin
  // }

  // getIsLogin() {
  //   return this.isLogin;
  // }

  // get isLoggedIn() {
  //   return this.loggedIn.asObservable();
  // }

  logout() {
    this.loggedIn.next(false);
    localStorage.setItem('isLogin', 'false');
    this.routerService.routeToLogin();
  }

  loginFailure() {
    this.loggedIn.next(false);
  }

}
