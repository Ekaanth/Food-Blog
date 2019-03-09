import { Component, Input, OnChanges } from '@angular/core';

@Component({
  selector: 'app-fivearticle',
  templateUrl: './fivearticles.component.html',
  styleUrls: ['./fivearticles.component.css']
})
export class FiveArticlesComponent implements OnChanges {

  @Input() articleList = [];
  constructor() { }

  ngOnChanges() {
    this.articleList = this.articleList;
  }

}
