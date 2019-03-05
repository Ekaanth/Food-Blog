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

  
  
  constructor(private instagramService: InstagramService, private router: Router,
     private articleTagsService: ArticleTagsService) { }

  ngOnInit() {
   
  }



}
