import { Component, OnInit } from '@angular/core';
import { InstagramService } from '../Service/instagramUserDetails';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private instagramService: InstagramService) { }

  ngOnInit() {
  }

}
