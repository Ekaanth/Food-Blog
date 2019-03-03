import {Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ArchiveComponent } from './archive/archive.component';
import { ArticleComponent } from './article/article.component';

export const approutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'about', component: AboutComponent},
    {path: 'contact', component: ContactComponent},
    {path: 'archive', component: ArchiveComponent},
    {path: 'archive/{id}', component: ArticleComponent},
];
