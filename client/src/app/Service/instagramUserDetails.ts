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
    const url = `https://api.instagram.com/v1/users/self/media/recent?count=10&access_token=1104083919.1677ed0.81d3aed1bfc1449280df2fd6d30cb5cf`;
    return this.http.get(url);
  }
}
