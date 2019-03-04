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
    const url = `${environment.appURL}/ClientController/api/addToSiteLog`;
    return this.http.post(url, details);
  }

  getIpdetails() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `https://ipapi.co/json`;
    return this.http.get(url);
  }
}
