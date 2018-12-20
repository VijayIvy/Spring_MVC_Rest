import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-one',
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css']
})
export class OneComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  @Input() paraentData: any;
  @Output() childDataEvent = new EventEmitter();

  getParaentData() {
    alert(this.paraentData);
  }

  passDataToParent() {
    alert('Hi');
    this.childDataEvent.emit('EmitVijay')
  }
}
