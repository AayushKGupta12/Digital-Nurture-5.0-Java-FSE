import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  courseCount = 0;
  portalName = "Student Course Portal";

  isPortalActive = true;

  message = "";

  searchTerm = "";

  onEnrollClick() {
    this.message = "Enrollment opened!";
  }

  ngOnInit(): void {

    this.courseCount = 12;

    console.log("HomeComponent initialized - courses loaded");

  }
  ngOnDestroy(): void {
    console.log("HomeComponent destroyed");
  }
}
