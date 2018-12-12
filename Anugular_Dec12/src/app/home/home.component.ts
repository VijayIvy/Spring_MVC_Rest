import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatIconModule, MatButtonModule, MatSidenavModule, MatToolbarModule
} from '@angular/material';
import { RouterService } from '../services/router.service';
import { AuthenticationService } from '../services/authentication.service';
import { WorkflowServiceService } from '../services/workflow-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private routerService: RouterService, private authService: AuthenticationService,
    private workflowServiceService: WorkflowServiceService) { }

  ngOnInit() {
    this.loadInitialData();
  }

  dataSource: any = [
  ];

  //workFlowDetailsList: any = [];
  displayedColumns: string[] = ['firstName', 'lastName', 'ctsEmpId', 'ctsEmailId', 'onBoardStatus', 'onBoardCoordinator'
    , 'projectName', 'ctsJoinDate', 'nmJoinDate', 'nmEndDate', 'teamName', 'location', 'projectRole', 'unit', 'update'];

  loadInitialData() {
    this.workflowServiceService.getWorkFlowDetails().subscribe((data: {}) => {
      //console.log('workflowServiceService getUnitDetails: ' + data);
      this.dataSource = data;
      console.log('this.getWorkFlowDetails: ' + this.dataSource[0].userName);
      //this.workFlowDetailsList = this.workFlowDetailsList[0].userName;
    });
  }

  update(row) {
    console.log(row.userName);
    this.workflowServiceService.setScope(row);
    this.routerService.routeToEdit();
  }
  search(searchInput: string) {
    const token = this.authService.getBearerToken();

    this.workflowServiceService.search(searchInput).subscribe(
      (data: {}) => {
        this.dataSource = data;
        console.log('this.search: ' + this.dataSource[0].userName);
        //this.routerService.routeToLogin();  
      }, error =>{
          alert('Invalid search')
      }
    );
  }
}




