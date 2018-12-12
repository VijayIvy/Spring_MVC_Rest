import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { RouterService } from '../services/router.service';
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
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  dataRowDetails;

  submitMessage: string = '';

  firstName = new FormControl('Vijay', [Validators.required]);
  
  lastName = new FormControl('', [Validators.required]);
  ctsEmailId = new FormControl('', [Validators.required,Validators.email]);
  ctsEmpId = new FormControl('', [Validators.required]);
  ctsJoinDate = new FormControl('', [Validators.required]);
  //ctsJoinDate: Date;
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

  constructor(private routerService: RouterService, private authService: AuthenticationService,
    private workflowServiceService: WorkflowServiceService) {
    this.submitMessage = '';
  };

  workflowUpdate() {
    console.log('workflowUpdate Submitted');
    console.log('workflowUpdate Unit' + this.unitDetails + ' buildingAccessRequest: ' + this.buildingAccessRequest
      + ' ctsEmailId: ' + this.ctsEmailId);
    if (this.ctsEmailId != null) {
      console.log('Iside If');
      this.workflowServiceService.updateWorkFlowRequest({
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
      }).subscribe((data: {}) => {
        //console.log('workflowServiceService getUnitDetails: ' + data);
        // this.units = data;
        console.log('this.updateWorkFlowRequest: ');
        console.log('this.updateWorkFlowRequest: ' + data);
      });
      console.log('Workflow Submitted Successfully');
    }
    this.routerService.routeToHome();
  }

  ngOnInit() {
    this.loadInitialData();
    this.loadInitialFields();
  }
  units: any = [];
  subUnits: any = [];
  nmProjectTypes: any = [];
  directors: any = [];
  anchors: any = [];
  locations: any = [];
  dataforupdate: any;

  loadInitialFields() {
    console.log('loadInitialFields');
    this.dataforupdate = this.workflowServiceService.getScope();
    //this.workflowServiceService.setRowdata();
       
    console.log('unit 000' + this.dataforupdate.unit);
    this.unitDetails = this.dataforupdate.unit;
    console.log('firstName 000' + this.dataforupdate.firstName);
    this.firstName = new FormControl(this.dataforupdate.firstName);
    this.lastName = new FormControl(this.dataforupdate.lastName);
    this.ctsEmailId = new FormControl(this.dataforupdate.ctsEmailId);
    this.ctsEmpId = new FormControl(this.dataforupdate.ctsEmpId);
    this.nmJoinDate = new FormControl(this.dataforupdate.nmJoinDate);
    this.ctsJoinDate = new FormControl(this.dataforupdate.ctsJoinDate);
    this.nmEndDate = new FormControl(this.dataforupdate.nmEndDate);
    this.experience = new FormControl(this.dataforupdate.experience);
    this.onBoardStatus = new FormControl(this.dataforupdate.onBoardStatus);
    this.onBoardCoOrdinator = new FormControl(this.dataforupdate.onBoardCoOrdinator);
    this.projectName = new FormControl(this.dataforupdate.projectName);
    this.projectRole = new FormControl(this.dataforupdate.projectRole);
    this.experience = new FormControl(this.dataforupdate.experience);
    this.teamName = new FormControl(this.dataforupdate.teamName);

    this.nmSow = new FormControl(this.dataforupdate.nmSow);
    this.nmLanId = new FormControl(this.dataforupdate.nmLanId);
    this.nmIsManager = new FormControl(this.dataforupdate.nmIsManager);
    this.classification = new FormControl(this.dataforupdate.classification);
    this.reason = new FormControl(this.dataforupdate.reason);
    this.assignTo = new FormControl(this.dataforupdate.assignTo);
    this.nmOnBoardStatus = new FormControl(this.dataforupdate.nmOnBoardStatus);
    this.nmOnBoardCoOrdinator = new FormControl(this.dataforupdate.nmOnBoardCoOrdinator);

    this.buildingAccessRequest = this.dataforupdate.buildingAccessRequest;
    this.drugTestException = this.dataforupdate.drugTestException;
    this.mutualCodeOfConduct = this.dataforupdate.mutualCodeOfConduct;
    this.ndaForm = this.dataforupdate.ndaForm;
    this.newMachineRequest = this.dataforupdate.newMachineRequest;
    this.nmDLUpdate = this.dataforupdate.nmDLUpdate;
    this.nmDrugTest = this.dataforupdate.nmDrugTest;
    this.nmDrugTestReRaised = this.dataforupdate.nmDrugTestReRaised;

    this.nmIntroductionTraining = this.dataforupdate.nmIntroductionTraining;
    this.ppmForm = this.dataforupdate.ppmForm;
    this.privacyBasics = this.dataforupdate.privacyBasics;
    this.prodTermId = this.dataforupdate.prodTermId;
    this.signOnForm = this.dataforupdate.signOnForm;
  }

  loadInitialData() {
    console.log('loadInitialData');

    const token = this.authService.getBearerToken();

    this.workflowServiceService.getUnitDetails().subscribe((data: {}) => {
      //console.log('workflowServiceService getUnitDetails: ' + data);
      this.units = data;
      console.log('this.getUnitDetails: ' + this.units);
      //this.unitDetails = this.units[0];
    }, );

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
