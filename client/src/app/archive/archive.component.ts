import { Component, OnInit } from '@angular/core';
import { ArticleTagsService } from '../Service/ArticleTagsService';

@Component({
  selector: 'app-archive',
  templateUrl: './archive.component.html',
  styleUrls: ['./archive.component.css']
})
export class ArchiveComponent implements OnInit {

  public allArticleslist;
  public categoryCount = [];
  constructor(private articleTag: ArticleTagsService) { }

  ngOnInit() {
    this.articleTag.findAllActiveArticlesPageination().subscribe(data => this.findAllActiveArticlesPageination(data));
    this.articleTag.getRandomCategoryCount().subscribe(data => this.getRandomCategoryCount(data));
  }

  findAllActiveArticlesPageination(data) {
    const articleList = JSON.parse(data._body);
    this.allArticleslist = articleList.content;
  }

  getRandomCategoryCount(data) {
    this.categoryCount = JSON.parse(data._body);
  }


  categoryTagClicked(catCount){

  }
}
