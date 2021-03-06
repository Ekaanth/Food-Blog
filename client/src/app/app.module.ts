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
import { SigninComponent } from './signin/signin.component';
import { AdminComponent } from './admin/admin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminarticlecomponentComponent } from './adminarticlecomponent/adminarticlecomponent.component';
import { AuthGuard } from './Service/AuthGuard';
import { AuthenticationService } from './Service/AuthenticationService';
import { HttpClientModule } from '@angular/common/http';
import { DraftarticlesComponent } from './draftarticles/draftarticles.component';
import { DraftarticlepublishComponent } from './draftarticlepublish/draftarticlepublish.component';
import { ClientService } from './Service/ClientServer';
import { NgxEditorModule } from 'ngx-editor';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { NgxSpinnerModule } from 'ngx-spinner';
import { ArticleTagsService } from './Service/ArticleTagsService';
import { FiveArticlesComponent } from './GenericComponents/fivearticles/fivearticles.component';
import { LatestPostComponent } from './GenericComponents/latestpost/latestpost.component';
import { SubscriptionService } from './Service/SubscriptionService';
import { CategoriesComponent } from './GenericComponents/categories/categories.component';
import { GenericArchiveComponent } from './GenericComponents/genericarchive/genericarchive.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    ArchiveComponent,
    ArticleComponent,
    SigninComponent,
    AdminComponent,
    AdmindashboardComponent,
    AdminarticlecomponentComponent,
    DraftarticlesComponent,
    DraftarticlepublishComponent,
    FiveArticlesComponent,
    LatestPostComponent,
    CategoriesComponent,
    GenericArchiveComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(approutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpModule,
    HttpClientModule,
    NgxEditorModule,
    NgMultiSelectDropDownModule.forRoot(),
    NgxSpinnerModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy },
    InstagramService,
    AuthGuard,
    AuthenticationService,
    ClientService,
    ArticleTagsService,
    SubscriptionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
