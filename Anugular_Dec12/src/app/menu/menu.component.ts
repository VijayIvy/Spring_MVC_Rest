import { Component, OnInit } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatIconModule, MatButtonModule, MatSidenavModule, MatToolbarModule
} from '@angular/material';
import { RouterService } from '../services/router.service'
import { WorkflowServiceService } from '../services/workflow-service.service';
import { AuthenticationService } from '../services/authentication.service';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  isLoggedIn$: Observable<boolean>;
  constructor(private routerService: RouterService, private authService: AuthenticationService,
    private workflowServiceService: WorkflowServiceService) {
    console.log('MenuComponent');
  }

  ngOnInit() {
    console.log(localStorage.getItem('isLogin'));
    if (localStorage.getItem('isLogin')) {
      this.isLoggedIn$ = this.authService.isLoggedIn;
    }
  }

  ngDestroy(){
    console.log('ndDestroy')
  }

  ngAfterContentInit(){
    console.log('ngAfterContentInit')
  }
  
  logOut() {
    console.log('logOut User');
    const token = this.authService.getBearerToken();
    localStorage.removeItem('vToken');
    this.workflowServiceService.logOut().subscribe(
      (data: Response) => {
        this.authService.logout();
      },
    );
  }



}
