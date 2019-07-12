import { Component, OnInit } from '@angular/core';
import { ArticleTagsService } from 'src/app/Service/ArticleTagsService';
import { Router, ActivatedRoute } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ClientService } from 'src/app/Service/ClientServer';

@Component({
  selector: 'app-genericarchive',
  templateUrl: './genericarchive.component.html',
  styleUrls: ['./genericarchive.component.css']
})
export class GenericArchiveComponent implements OnInit {

  public articleId;
  public articleDetails = null;
  public articelSubtags = [];
  public categoryCount = [];
  constructor(  private spinner: NgxSpinnerService , private router: Router, private articleTagsService: ArticleTagsService,
    private route: ActivatedRoute, private clientService: ClientService) { }

  ngOnInit() {
    this.spinner.show();
    // this.articleId = this.route.snapshot.paramMap.get('id');
    this.route.params.subscribe( params =>  this.paramsSub(params));
  }

  paramsSub(params) {
    this.clientService.getArticleById(params.id).subscribe(data => this.getArticleById(data));
    this.articleTagsService.getRandomCategoryCount().subscribe(data => this.getRandomCategoryCount(data));
    this.articleTagsService.populatTagsLog(params.id).subscribe();
  }

  getRandomCategoryCount(data) {
    this.categoryCount = JSON.parse(data._body);
  }

  getArticleById(data) {
    console.log(data);
    if (data._body !== '') {
      this.articleDetails = JSON.parse(data._body);
      this.articelSubtags =  this.articleDetails.articleSubtags;
      console.log(this.articleDetails);
      this.spinner.hide();
    } else {
      this.router.navigateByUrl('/');
    }
  }

  tagClicked(item) {
  }
}
