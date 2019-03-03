import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule, Routes } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import { approutes } from './app.router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ArchiveComponent } from './archive/archive.component';
import { ArticleComponent } from './article/article.component';
import { InstagramService } from './Service/instagramUserDetails';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    ArchiveComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(approutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpModule,
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy },
    InstagramService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
