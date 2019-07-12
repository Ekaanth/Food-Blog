import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'src/environments/environment';

@Injectable()
export class ArticleTagsService {
  private base_url: string;
  private header: Headers;
  constructor(private http: Http) {
  }

  getLatestFiveArticles() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ArticleTagsController/api/getLatestFiveArticles?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }

  getRandomCategoryCount() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ArticleTagsController/api/getRandomCategoryCount?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }

  findAllActiveArticlesPageination() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ArticleTagsController/api/findAllActiveArticlesPageination?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }

  populatTagsLog(id) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ArticleTagsController/api/populatTagsLog?id=${id}&sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }

  findAllActiveArticlesByTag(id) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ArticleTagsController/api/findAllActiveArticlesByTag/${id}?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }
}
