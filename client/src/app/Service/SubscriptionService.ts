import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'src/environments/environment';

@Injectable()
export class SubscriptionService {
  private base_url: string;
  private header: Headers;
  constructor(private http: Http) {
  }

  subscribe(email) {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `${environment.appURL}SubscriptionController/api/subscribe/${email}?sysdatetime=${fulldatetime}`;
    return this.http.get(url);
  }
}
