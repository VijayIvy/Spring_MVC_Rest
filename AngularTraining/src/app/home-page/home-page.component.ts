import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CommunicationService} from '../communication.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private routeRef: Router, private commService: CommunicationService) { }

uName:any;
  ngOnInit() {
  }
  Route() {
    this.commService.setuser('Vijay')
    this.routeRef.navigate(['Profile'])
  }
}
