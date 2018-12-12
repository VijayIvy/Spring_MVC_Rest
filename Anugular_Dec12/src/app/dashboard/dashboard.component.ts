import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { RouterService } from '../services/router.service';
//import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { AuthenticationService } from '../services/authentication.service';
import { HttpErrorResponse } from '@angular/common/http';
import { WorkflowServiceService } from '../services/workflow-service.service';
import { Response } from '@angular/http';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatGridListModule, MatGridList, MatGridTile, MatGridTileText } from '@angular/material/grid-list';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatIconModule, MatButtonModule, MatSidenavModule, MatToolbarModule
} from '@angular/material';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  submitMessage: string = '';

  firstName = new FormControl('Vijay', [Validators.required]);
  lastName = new FormControl('', [Validators.required]);
  ctsEmailId = new FormControl('', [Validators.required]);
  ctsEmpId = new FormControl('', [Validators.required]);
  //ctsJoinDate = new FormControl('', [Validators.required]);
  ctsJoinDate: Date;
  nmJoinDate = new FormControl('', [Validators.required]);
  nmEndDate = new FormControl('', [Validators.required]);
  experience = new FormControl('', [Validators.required]);
  onBoardStatus = new FormControl('', [Validators.required]);
  onBoardCoOrdinator = new FormControl('', [Validators.required]);
  projectName = new FormControl('', [Validators.required]);
  projectRole = new FormControl('', [Validators.required]);
  teamName = new FormControl('', [Validators.required]);
  unitDetails: string;
  subUnitDetails: string;
  directorsDetails: string;
  anchorsDetails: string;
  nmProjectTypesDetails: string;
  location: string;
  nmSow = new FormControl('', [Validators.required]);
  nmLanId = new FormControl('', Validators.required);
  nmIsManager = new FormControl('', Validators.required);
  classification = new FormControl('', Validators.required);
  reason = new FormControl('', Validators.required);
  assignTo = new FormControl('', Validators.required);
  nmOnBoardStatus = new FormControl('', [Validators.required]);
  nmOnBoardCoOrdinator = new FormControl('', [Validators.required]);
  buildingAccessRequest: string;
  drugTestException: string;
  mutualCodeOfConduct: string;
  ndaForm: string;
  newMachineRequest: string;
  nmDLUpdate: string;
  nmDrugTest: string;
  nmDrugTestReRaised: string;
  nmIntroductionTraining: string;
  ppmForm: string;
  privacyBasics: string;
  prodTermId: string;
  signOnForm: string;

  //this.nmLanId ='asda';


  constructor(private routerService: RouterService, private authService: AuthenticationService,
    private workflowServiceService: WorkflowServiceService) {
    this.submitMessage = '';
  };

  units1 = [
    "EPS",
    "EIRC",
    "ETM",
    "Planning Experience"
  ];

  subUnits1 = [
    "Shared Services",
    "CTS",
    "EVF",
    "IRP",
    "Consulting",
    "Projects",
    "Support",
    "Transition"
  ];
  directors1 = [
    "JOE",
    "LEE",
    "LIN",
    "ASA"
  ];

  anchors1 = [
    "JOE",
    "LEE",
    "LIN",
    "ASA"
  ];
  locations1 = [
    {
      "m_sLocationId": 1,
      "m_sLocationName": "OFF-CHENNAI",
      "m_sLocationPDL": "Vijay.I@cognizant.com"
    },
    {
      "m_sLocationId": 2,
      "m_sLocationName": "OFF-KOCHI",
      "m_sLocationPDL": "Vijay.I@cognizant.com"
    },
    {
      "m_sLocationId": 3,
      "m_sLocationName": "OFF-COIMBATORE",
      "m_sLocationPDL": "Vijay.I@cognizant.com"
    },
    {
      "m_sLocationId": 4,
      "m_sLocationName": "ON-MILWAUKEE",
      "m_sLocationPDL": "Vijay.I@cognizant.com"
    }
  ];
  nmProjectTypes1 = [
    "Agile",
    "FB",
    "FC",
    "Non Billable"
  ];

  workflowSubmit() {
    console.log('Workflow Submitted');
    console.log('Workflow Unit' + this.unitDetails + ' buildingAccessRequest: ' + this.buildingAccessRequest
      + ' ctsEmailId: ' + this.ctsEmailId.value);
    if (this.ctsEmailId != null) {
      console.log('Iside If');
      this.workflowServiceService.saveWorkFlowRequest({
        'firstName': this.firstName.value,
        'lastName': this.lastName.value, 'ctsEmailId': this.ctsEmailId.value,
        'ctsEmpId': this.ctsEmpId.value, //'experience':this.experience.value,
        'onBoardStatus': this.onBoardStatus.value,
        'onBoardCoOrdinator': this.onBoardCoOrdinator.value, 'projectName': this.projectName.value,
        'projectRole': this.projectRole.value, 'teamName': this.teamName.value,
        'unit': this.unitDetails, 'subUnit': this.subUnitDetails,
        'locationId': this.locations[0].m_sLocationId, 'location': this.locations[0].m_sLocationName,
        'directors': this.directors[0],// 'experience':this.experience.value,
        'anchors': this.anchors[0], 'nmProjectType': this.nmProjectTypes.value,
        'nmSow': this.nmSow.value, 'nmLanId': this.nmLanId.value,
        'nmIsManager': this.nmIsManager.value, 'classification': this.classification.value,
        'reason': this.reason.value, 'assignTo': this.assignTo.value,
        'nmOffBoardStatus': this.nmOnBoardStatus.value, 'nmOffBoardCoordinator': this.nmOnBoardCoOrdinator.value,
        'buildingAccessRequest': this.buildingAccessRequest, 'drugTestException': this.drugTestException,
        'mutualCodeOfConduct': this.mutualCodeOfConduct, 'ndaForm': this.ndaForm,
        'newMachineRequest': this.newMachineRequest, 'nmDLUpdate': this.nmDLUpdate,
        'nmDrugTest': this.nmDrugTest, 'nmDrugTestReRaised': this.nmDrugTestReRaised,
        'nmIntroductionTraining': this.nmIntroductionTraining, 'ppmForm': this.ppmForm,
        'privacyBasics': this.privacyBasics, 'prodTermId': this.prodTermId,
        'signOnForm': this.signOnForm
      }).subscribe(
        (data: {}) => {
          console.log(data);
          console.log("authenticateUser: ");

          this.routerService.routeToHome();          
        },error => {
          alert("Something went Wrong")
        }
      );
      console.log('Workflow Submitted Successfully');
    }
    //this.routerService.routeToHome();
  }

  ngOnInit() {
    //console.log('loadng Initial Data');
    this.loadInitialData();

  }

  //units1: string[]=[];

  units: any = [];
  subUnits: any = [];
  nmProjectTypes: any = [];
  directors: any = [];
  anchors: any = [];
  locations: any = [];

  loadInitialData() {
    console.log('loadInitialData');
    const token = this.authService.getBearerToken();

    this.workflowServiceService.getUnitDetails().subscribe((data: {}) => {
      //console.log('workflowServiceService getUnitDetails: ' + data);
      this.units = data;
      console.log('this.getUnitDetails: ' + this.units);
      this.unitDetails = this.units[0];
    },);

    this.workflowServiceService.getSubUnitDetails().subscribe((data: {}) => {
      //console.log('workflowServiceService getSubUnitDetails: ' + data);
      this.subUnits = data;
      console.log('this.getSubUnitDetails: ' + this.subUnits);
    });


    this.workflowServiceService.getProjectTypeDetails().subscribe((data: {}) => {
      // console.log('workflowServiceService getProjectTypeDetails: ' + data);
      this.nmProjectTypes = data;
      console.log('this.getProjectTypeDetails: ' + this.nmProjectTypes);
    });

    this.workflowServiceService.getDirectors().subscribe((data: {}) => {
      //console.log('workflowServiceService getDirectors: ' + data);
      this.directors = data;
      console.log('this.getDirectors: ' + this.directors);
    });

    this.workflowServiceService.getAnchors().subscribe((data: {}) => {
      //console.log('workflowServiceService getAnchors: ' + data);
      this.anchors = data;
      console.log('this.getAnchors: ' + this.anchors);
    });

    this.workflowServiceService.getLocations().subscribe((data: {}) => {
      // console.log('workflowServiceService getLocations: ' + data);
      this.locations = data;
      console.log('this.getLocations: ' + this.locations[0].m_sLocationName);
    });

    this.buildingAccessRequest = "Yes";

  }

  validatefirstName() {
    return this.firstName.hasError('required') ? 'Employee First Name is Required' : '';
  }

  validatelastName() {
    return this.lastName.hasError('required') ? 'Employee Last Name is Required' : '';
  }

  validateCtsEmailId() {
    return this.ctsEmailId.hasError('required') ? 'Email Id is Required' : '';
  }

  validateCtsEmpId() {
    return this.ctsEmpId.hasError('required') ? 'Employee Id is Required' : '';
  }
  validateExperience() {
    return this.experience.hasError('required') ? 'Employee Experience is Required' : '';
  }

  validateOnBoardStatus() {
    return this.onBoardStatus.hasError('required') ? 'On-Board Status is Required' : '';
  }
  validateOnBoardCoOrdinator() {
    return this.onBoardCoOrdinator.hasError('required') ? 'On-Board Co-Ordinator is Required' : '';
  }
  validateProjectName() {
    return this.projectName.hasError('required') ? 'Project Name is Required' : '';
  }
  validateProjectRole() {
    return this.projectRole.hasError('required') ? 'Project Role is Required' : '';
  }
  validateTeamName() {
    return this.teamName.hasError('required') ? 'Team Name is Required' : '';
  }

  validateNmSow() {
    return this.nmSow.hasError('required') ? 'NmSow is Required' : '';
  }
  validateNmLanId() {
    return this.nmLanId.hasError('required') ? 'Nm LanID is Required' : '';
  }
  validateNmIsManager() {
    return this.nmIsManager.hasError('required') ? 'Nm Manager is Required' : '';
  }
  validateClassification() {
    return this.classification.hasError('required') ? 'Classification is Required' : '';
  }
  validateReason() {
    return this.reason.hasError('required') ? 'Reason is Required' : '';
  }

  validateAssignTo() {
    return this.reason.hasError('required') ? 'Assign To is Required' : '';
  }

  validateNmOnBoardStatus() {
    return this.nmOnBoardStatus.hasError('required') ? 'NmOffboard status is Required' : '';
  }
  validateNmOnBoardCoOrdinator() {
    return this.nmOnBoardCoOrdinator.hasError('required') ? 'NmOffBoard co-Ordinator is Required' : '';
  }

}

interface LocDetails {
  m_sRoleId: number;
  m_sRoleName: String;
  m_sLocationId: number;
  m_sLocationPDL: String;
  m_sUserName: String;
  m_sUserId: number;
}
