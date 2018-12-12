import { Component } from '@angular/core';
import { RouterService } from '../services/router.service'
import { WorkflowServiceService } from '../services/workflow-service.service';
import { AuthenticationService } from '../services/authentication.service';
import { Response } from '@angular/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isNoteView = true;

  constructor(private routerService: RouterService, private authService: AuthenticationService,
    private workflowServiceService: WorkflowServiceService) {

  }
  switchToNoteView() {
    //this.routerService.routeToNoteView();
    this.isNoteView = true;
  }
  switchToListView() {
    //this.routerService.routeToListView();
    this.isNoteView = false;
  }

  // logOut() {
  //   console.log('logOut User');
  //   const token = this.authService.getBearerToken();
  //   this.workflowServiceService.logOut().subscribe(
  //     (data: Response) => {
  //       this.routerService.routeToLogin();
  //       localStorage.removeItem('vToken');
  //       console.log('vToken' + localStorage.getItem('vToken'));
  //     },
  //   );

  // }

}
