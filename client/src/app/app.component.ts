import { Component, OnInit } from '@angular/core';
import { ClientService } from './Service/ClientServer';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  constructor(private clientService: ClientService) {

  }

  ngOnInit() {
    this.clientService.getIpdetails().subscribe(data => this.getIpDetails(data));
  }

  getIpDetails(data) {
    const details = JSON.parse(data._body);
    let date = new Date();
    const logDetails = {
      ipaddress: details.ip,
      city: details.city,
      region: details.region,
      countryname: details.country_name,
      timestamp: date.getTime
    };
    this.clientService.addToSiteLog(logDetails).subscribe();
  }

}
