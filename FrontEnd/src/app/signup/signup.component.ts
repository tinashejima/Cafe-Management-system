import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  standalone: false,
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  password = true;
  confirmpassword = true;

  constructor() { }

  ngOnInit(): void {
  }

}
