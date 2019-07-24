import { Component, Input, OnChanges } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fivearticle',
  templateUrl: './fivearticles.component.html',
  styleUrls: ['./fivearticles.component.css']
})
export class FiveArticlesComponent implements OnChanges {

  @Input() allArticleList = [];
  public olderOff = false;
  public newerOff = false;
  public current_page = 1;
  public records_per_page = 5;
  public articleList = [];
  constructor(private router: Router) {
    this.allArticleList = [];
  }

  ngOnChanges() {
    this.articleList = this.allArticleList;
    if (this.allArticleList !== undefined) {
      this.changePage(1);
    }
  }

  clickOnPost(article) {
    this.router.navigateByUrl('/article/' + article.id);
  }

  previousClicked() {
    if (this.current_page > 1) {
        this.current_page--;
        this.changePage(this.current_page);
    }
}

nextClicked() {
    if (this.current_page < this.numPages()) {
        this.current_page++;
        this.changePage(this.current_page);
    }
}

changePage(page) {
  this.articleList = [];
    // Validate page
    if (page < 1) {
      page = 1;
    }
    if (page > this.numPages()) {
      page = this.numPages();
    }

    for (let i = (page - 1) * this.records_per_page; i < (page * this.records_per_page); i++) {
        this.articleList.push(this.allArticleList[i]);
    }

    if (page === 1) {
      this.newerOff = false;
    } else {
      this.newerOff = true;
    }

    if (page === this.numPages()) {
      this.olderOff = false;
    } else {
      this.olderOff = true;
    }
}

numPages() {
  if (this.allArticleList) {
    return Math.ceil(this.allArticleList.length / this.records_per_page);
  }
}

}
