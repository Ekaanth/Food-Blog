import { Component, OnInit } from '@angular/core';
import { InstagramService } from '../Service/instagramUserDetails';
import { ArticleTagsService } from '../Service/ArticleTagsService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private instaImages = [];

  constructor(private instagramService: InstagramService, private router: Router,
     private articleTagsService: ArticleTagsService) { }

  ngOnInit() {
   this.instagramService.getInstaUserDetails().subscribe(data => this.getInstaUserDetails(data));
  }

  getInstaUserDetails(data) {
    console.log(data);
    let instaData = JSON.parse(data._body);
    this.instaImages = instaData.data;
  }


}
