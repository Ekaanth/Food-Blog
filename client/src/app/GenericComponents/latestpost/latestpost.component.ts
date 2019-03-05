import { Component, OnInit } from '@angular/core';
import { ArticleTagsService } from 'src/app/Service/ArticleTagsService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-latestpost',
  templateUrl: './latestpost.component.html',
  styleUrls: ['./latestpost.component.css']
})
export class LatestPostComponent implements OnInit {

  public latestPost = [];

  constructor(private articleTagsService: ArticleTagsService, private router: Router) { }

  ngOnInit() {
    this.articleTagsService.getLatestFiveArticles().subscribe(data => this.getLatestFiveArticles(data));
  }

  getLatestFiveArticles(data) {
    this.latestPost = JSON.parse(data._body);
  }

  latestPostClicked(post) {
    this.router.navigateByUrl('/article/' + post.id);
  }
}
