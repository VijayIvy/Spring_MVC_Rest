import { Component } from '@angular/core';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'AngularTraining -Vijay';
  username: string = "asa";
  RespData: any;
  ErrorData: any;

  constructor(private httpref: HttpClient) {
  };

  Username = new FormControl('', [Validators.required]);
  Password = new FormControl('', [Validators.required, Validators.minLength(8)]);

  emp: any = [{ name: "asdasd", id: 123123 },
  { name: "asdasd1231", id: 12312233 }];

  creds: any = { Username: "Vijay", Password: "Vijay" };

  getUser(event) {
    //console.log(this.username);
  }

  onSubmit() {
    // if (this.Username = this.creds.Username) && (this.Password = this.creds.Password ){

    //}
  }

  getService() {
    let headers = new HttpHeaders();
    //this.createAuthorizationHeader(headers);
    headers.set('Content-Type', 'application/json; charset=utf-8');
    this.httpref.post('http://10.219.203.145:8080/NMJML/getUnitDetails', { headers }).subscribe(
      data => {
        console.log(data);
        this.RespData = data;
      }, error => {
        console.log(error);
        alert(error);
        this.ErrorData = error.message;
      });
  }
}
