import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

  constructor() { }

  user: string;

  getUser() {
    return this.user;
  }
  setuser(data) {
    this.user = data;
  }
}
