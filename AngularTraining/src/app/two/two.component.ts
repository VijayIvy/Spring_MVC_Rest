import { NgModule, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-two',
  templateUrl: './two.component.html',
  styleUrls: ['./two.component.css']
})
export class TwoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  recievedData: any;
  uName: any;


  recieveData(data) {
    console.log('recieveData')
    this.recievedData = data;
  }

  getdataFromChild(data) {
    alert('getdataFromChild');
    console.log(data);
  }

}
