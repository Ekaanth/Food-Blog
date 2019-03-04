import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('user') !== 'login') {
      this.router.navigate(['/admin']);
    }
  }

  logoutClicked() {
    this.router.navigate(['/']);
    localStorage.clear();
    window.location.reload();
  }

}
