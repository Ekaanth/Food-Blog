import { Component, OnInit } from '@angular/core';
import { ClientService } from '../Service/ClientServer';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-adminarticlecomponent',
  templateUrl: './adminarticlecomponent.component.html',
  styleUrls: ['./adminarticlecomponent.component.css']
})
export class AdminarticlecomponentComponent implements OnInit {
  public dropdownList = [];
  public dropdownSingleList = [];
  public selectedItems;
  public dropdownSingleSettings;
  public mainTag;
  public subTags = [];
  public dropdownMultiSettings;
  public articlename;
  public articleby;
  public firstparagraph;
  public secondparagraph;
  public articlMaintag;
  public articlesecondtsgs;
  public articlequote;
  public articlequoteby;

  constructor(private clientService: ClientService, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.spinner.show();
 
    setTimeout(() => {
        this.spinner.hide();
    }, 3000);

    this.dropdownList = [
    ];
    this.dropdownSingleList = [];
    this.selectedItems = [
    ];
    this.clientService.getAllTags().subscribe(data => this.getAllTags(data));
    this.dropdownSingleSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'tagName',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
    this.dropdownMultiSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'tagName',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  getAllTags(data) {
    const tags = JSON.parse(data._body);
    if (tags.length > 0) {
      this.dropdownList = tags;
      this.dropdownSingleList = tags;
    }
  }

  fileChanged($event) {

  }

  onSingleItemSelect(event) {
    this.mainTag = event;
  }

  onItemSelect(event) {
    this.subTags.push(event);
  }

  publishPost() {
    const articleDetails = {
      articleHeading : this.articlename,
      articleBy: this.articleby,
      articleFirstParagraph: this.firstparagraph,
      articleSecondParagraph: this.secondparagraph,
      articleMaintag: this.mainTag,
      articleSubtags: this.subTags,
      articleQuote: this.articlequote,
      articelQuoteAuthor: this.articlequoteby
    };
    console.log(articleDetails);
    this.clientService.draftArticle(articleDetails).subscribe();
  }

  onItemDeselected(event) {
    console.log(event);
    for (let index = 0; index < this.subTags.length; index++) {
      if (this.subTags[index].id === event.id) {
        this.subTags.splice(index, 1);
        break;
      }
    }
  }

  onSelectAll(event) {
    this.subTags = event;
  }

}
