import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  data = {}  as any;
  cars: any;
  constructor() {
    this.title = 'Spring Boot - Angular Application';
  }
}
