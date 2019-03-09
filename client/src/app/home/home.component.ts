import { Component, OnInit } from '@angular/core';
import { InstagramService } from '../Service/instagramUserDetails';
import { ArticleTagsService } from '../Service/ArticleTagsService';
import { Router } from '@angular/router';
import { ClientService } from '../Service/ClientServer';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SubscriptionService } from '../Service/SubscriptionService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public instaImages = [];
  public latestPost = [];
  public newsletter: FormGroup;
  public paginationArticles: any;
  public listOfArticles = [];
  constructor(private instagramService: InstagramService, private router: Router, private clientService: ClientService,
     private articleTagsService: ArticleTagsService, private fb: FormBuilder, private subscriptionService: SubscriptionService) {
       this.newsletter = this.fb.group({
         email: [ '',  [Validators.required , Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]]
       });
     }

  ngOnInit() {
   this.instagramService.getInstaUserDetails().subscribe(data => this.getInstaUserDetails(data));
   this.articleTagsService.getLatestFiveArticles().subscribe(data => this.getLatestFiveArticles(data));
   this.articleTagsService.findAllActiveArticlesPageination().subscribe(data => this.getAllPaginationArticle(data));
  }

  getAllPaginationArticle(data) {
    this.paginationArticles = JSON.parse(data._body);
    this.listOfArticles = this.paginationArticles.content;
  }
 
  getLatestFiveArticles(data) {
    this.latestPost = JSON.parse(data._body);
  }

  getInstaUserDetails(data) {
    console.log(data);
    const instaData = JSON.parse(data._body);
    this.instaImages = instaData.data;
  }
  newslettterSubmit() {
    this.subscriptionService.subscribe(this.newsletter.controls.email.value).subscribe(data => this.newsletter.reset());
  }


}
