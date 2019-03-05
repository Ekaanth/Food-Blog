import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from '../Service/ClientServer';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  public articleId;
  public articleDetails: any;

  constructor(  private spinner: NgxSpinnerService , private route: ActivatedRoute, private clientService: ClientService) { }

  ngOnInit() {
    this.spinner.show();
    this.articleId = this.route.snapshot.paramMap.get('id');
    this.clientService.getArticleById(this.articleId).subscribe(data => this.getArticleById(data));
  }

  getArticleById(data) {
    this.articleDetails = JSON.parse(data._body);
    console.log(this.articleDetails);
    this.spinner.hide();
  }

}
