import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private routeRef: Router, private commService: CommunicationService) { }
  username: any;
  ngOnInit() {
    this.username = this.commService.getUser;
  }
  Route() {
    this.routeRef.navigate(['Home'])
  }
  RouteOne() {
    this.routeRef.navigate(['Two'])
  }

}
