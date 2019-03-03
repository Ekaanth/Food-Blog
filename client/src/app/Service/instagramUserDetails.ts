import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class InstagramService {
  private base_url: string;
  private header: Headers;
  constructor(private http: Http) {
  }

  getInstaUserDetails() {
    const sysDateTime = new Date();
    const fulldatetime = sysDateTime.getTime();
    const url = `https://api.instagram.com/v1/users/self/media/recent?count=10&access_token=
                1104083919.1677ed0.491d51fea98f42dc824ed893488beb50`;
    return this.http.get(url);
  }
}
