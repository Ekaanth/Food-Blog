import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'src/environments/environment';

@Injectable()
export class ClientService {
  private base_url: string;
  private header: Headers;
  constructor(private http: Http) {
  }

  addToSiteLog(details) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ClientController/api/addToSiteLog?sysdatetime=${fulldatetime}`;
    return this.http.post(url, details);
  }

  getIpdetails() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `https://ipapi.co/json`;
    return this.http.get(url);
  }

  getAllTags() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ClientController/api/getAllTags?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }

  publishArticle(details) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ClientController/api/publishArticle?sysdatetime=${fulldatetime}`;
    return this.http.post(url, details);
  }

  draftArticle(details) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}ClientController/api/draftArticle?sysdatetime=${fulldatetime}`;
    return this.http.post(url, details);
  }
}
