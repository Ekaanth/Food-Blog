import {Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ArchiveComponent } from './archive/archive.component';
import { ArticleComponent } from './article/article.component';
import { SigninComponent } from './signin/signin.component';
import { AdminComponent } from './admin/admin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminarticlecomponentComponent } from './adminarticlecomponent/adminarticlecomponent.component';
import { GenericArchiveComponent } from './GenericComponents/genericarchive/genericarchive.component';
import { DraftarticlepublishComponent } from './draftarticlepublish/draftarticlepublish.component';

export const approutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'about', component: AboutComponent},
    {path: 'contact', component: ContactComponent},
    {path: 'allposts', component: ArchiveComponent},
    {path: 'article/:id', component: ArticleComponent},
    {path: 'tagsarchive/:archivename/:string', component: GenericArchiveComponent},
    {path: 'admin', component: SigninComponent},
    {path: 'adminpage',  component: AdminComponent,
            children: [
                {
                    path: '',
                    component: AdmindashboardComponent
                },
                {
                    path: 'newarticle',
                    component: AdminarticlecomponentComponent
                },
                {
                    path: 'draftarticles',
                    component: DraftarticlepublishComponent
                }
            ]
        },
        { path: '**', redirectTo: '' }
];
