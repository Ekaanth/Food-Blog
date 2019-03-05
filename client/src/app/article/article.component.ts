import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../Service/ClientServer';
import { ArticleTagsService } from '../Service/ArticleTagsService';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  public articleId;
  public articleDetails: any;
  public articelSubtags = [];
  constructor(  private spinner: NgxSpinnerService , private router: Router, private articleTagsService: ArticleTagsService,
    private route: ActivatedRoute, private clientService: ClientService) { }

  ngOnInit() {
    this.spinner.show();
    this.articleId = this.route.snapshot.paramMap.get('id');
    this.clientService.getArticleById(this.articleId).subscribe(data => this.getArticleById(data));
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

}
