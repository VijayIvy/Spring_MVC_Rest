import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Response, Headers } from '@angular/http';
import { AuthenticationService } from '../services/authentication.service';

@Injectable()
export class WorkflowServiceService {
  getUnitDetailsUrl = 'http://10.219.203.183:8080/NMJML/getUnitDetails';
  getSubUnitDetailsUrl = 'http://10.219.203.183:8080/NMJML/getSubUnitDetails';
  getProjectTypeDetailsUrl = 'http://10.219.203.183:8080/NMJML/getProjectTypeDetails';
  saveWorkFlowRequestUrl = 'http://10.219.203.183:8080/NMJML/saveWorkFlowRequest';
  getDirectorsUrl = 'http://10.219.203.183:8080/NMJML/getDirectors';
  getAnchorsUrl = 'http://10.219.203.183:8080/NMJML/getAnchors';
  getLocationsUrl = 'http://10.219.203.183:8080/NMJML/getLocations';
  getWorkFlowDetailsUrl = 'http://10.219.203.183:8080/NMJML/retrieveWorkFlowDetails';
  logoutUrl = 'http://10.219.203.183:8080/NMJML/logout';
  getSearchWorkFlowDetailsUrl = 'http://10.219.203.183:8080/NMJML/searchWorkFlowDetails';
  updateWorkFlowRequestUrl = 'http://10.219.203.183:8080/NMJML/updateWorkFlowRequest';
  constructor(private httpClient: HttpClient) { }

  private createAuthorizationHeader(headers: HttpHeaders) {
    headers.set('Content-Type', 'application/json; charset=utf-8');
    headers.set('Authorization', localStorage.getItem('vToken'));
  }

  getUnitDetails() {
    //console.log("getUnitDetails");
    console.log("getUnitDetails Token" + localStorage.getItem('vToken'));

    let headers = new HttpHeaders();
    //this.createAuthorizationHeader(headers);
    headers.set('Content-Type', 'application/json; charset=utf-8');
    headers.set('Authorization', localStorage.getItem('vToken'));
    headers.set("Access-Control-Allow-Headers", "*");
    headers.set("Access-Control-Expose-Headers", "*");
    headers.set("Access-Control-Allow-Credentials", "true");
    console.log('Headers1: ' + headers.get('Authorization'));
    console.log('Headers2: ' + headers.get('Content-Type'));

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json', 'Authorization': localStorage.getItem('vToken'),
      })
    };
    return this.httpClient.post(`${this.getUnitDetailsUrl}`, {}, { headers });
  }

  public subUnits: string[];


  getSubUnitDetails() {
    //console.log("getSubUnitDetails");
    let resource;
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    headers.set('Authorization', localStorage.getItem('vToken'));
    headers.set("Access-Control-Allow-Origin", "*");
    headers.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

    return this.httpClient.post(`${this.getSubUnitDetailsUrl}`, {}, { headers });
  }

  getProjectTypeDetails() {
    //console.log("getProjectTypeDetails");
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getProjectTypeDetailsUrl}`, { headers });
  }

  getDirectors() {
    // console.log("getDirectors");
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getDirectorsUrl}`, { headers });
  }

  getAnchors() {
    //console.log("getAnchors");
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getAnchorsUrl}`, { headers });
  }

  getLocations() {
    //console.log("getLocations");
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getLocationsUrl}`, { headers });
  }

  saveWorkFlowRequest(data) {
    console.log("Service saveWorkFlowRequest" + data);
    let resource = JSON.stringify(data);

    console.log("resource" + resource);
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    this.createAuthorizationHeader(headers);
    console.log('Headers1: ' + headers.get('Authorization'));
    return this.httpClient.post(`${this.saveWorkFlowRequestUrl}`, resource, { headers });
  }

  updateWorkFlowRequest(data) {
    console.log("Service updateWorkFlowRequestUrl" + data);
    let resource = JSON.stringify(data);

    console.log("resource" + resource);
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    this.createAuthorizationHeader(headers);
    console.log('Headers1: ' + headers.get('Authorization'));
    return this.httpClient.post(`${this.updateWorkFlowRequestUrl}`, resource, { headers });
  }

  getWorkFlowDetails() {
    console.log("Service getWorkFlowDetails");
    //let resource = JSON.stringify();
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'No Needcccccccccccccvvvvvvvvvvv');
    // this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getWorkFlowDetailsUrl}`, { headers });
  }
  logOut() {
    console.log("getDirectors");
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.logoutUrl}`, {}, { headers });
  }

  scope;
  public getScope(): Array<any> | boolean {
    return this.scope;
  }

  public setScope(scope: any): void {
    console.log('scope');
    console.log(scope);
    this.scope = scope;
  }
  search(data) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    console.log('search input : ' + data);
    //   let resource = JSON.stringify(data);
    let resource = { "m_sSearch": data };
    console.log('resource ' + JSON.stringify(resource));
    // this.createAuthorizationHeader(headers);
    return this.httpClient.post(`${this.getSearchWorkFlowDetailsUrl}`, JSON.stringify(resource), { headers });
  }

  dataforupdate: any;
  public setRowdata() {
    this.dataforupdate = {
      "userName": "POCUser",
      "userRole": 2,
      "workFlowId": 17,
      "firstName": "Nanda",
      "lastName": "Kumar",
      "ctsEmpId": 666555,
      "ctsEmailId": "0",
      "onBoradStatus": "To Do",
      "onBoradCoordinator": "Joe",
      "projectName": "Dream",
      "ctsJoinDate": "2018-03-12",
      "nmJoinDate": "2018-03-12",
      "nmEndDate": "2018-03-12",
      "teamName": "NM ISSUE",
      "location": "OFF-CHENNAI",
      "locationId": 1,
      "projectRole": "Agile",
      "unit": "EPS",
      "subUnit": "",
      "directors": "John H Knecht",
      "anchors": "Bunty",
      "nmProjectType": "FB",
      "nmSow": "29",
      "nmLanId": "",
      "nmIsManager": "",
      "classification": "",
      "reason": "",
      "assignTo": "",
      "nmOffBoardStatus": "",
      "nmOffBoardCoordinator": "",
      "mutualCodeOfConduct": "Yes",
      "drugTestException": "No",
      "privacyBasics": "No",
      "newMachineRequest": "Yes",
      "signOnForm": "No",
      "ppmForm": "Yes",
      "ndaForm": "Yes",
      "nmDrugTestReRaised": "Yes",
      "nmIntroductionTraining": "No",
      "nmDLUpdate": "No",
      "nmDrugTest": "No",
      "prodTermId": "No",
      "nmDetailid": 100
    };
  }
  public getRowdata() {
    return this.dataforupdate;
  }
}

 // public finallist = []
  // getList() {
  //   console.log("getSubUnitDetails");
  //   let resource;
  //   let headers = new HttpHeaders();
  //   headers = headers.set('Content-Type', 'application/json; charset=utf-8');
  //   headers.set('Authorization', 'Bearer ');
  //   return this.httpClient.post(`${this.getSubUnitDetailsUrl}`, resource, { headers }).subscribe(data => {
  //     this.finallist = JSON.parse(data['_body']);
  //     return this.finallist;
  //   })
  // }