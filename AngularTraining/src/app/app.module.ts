import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfileComponent } from './profile/profile.component';
import {CommunicationService} from './communication.service';
import { OneComponent } from './one/one.component';
import { TwoComponent } from './two/two.component';
import { ThreeComponent } from './three/three.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    ProfileComponent,
    OneComponent,
    TwoComponent,
    ThreeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'Login',
        component: LoginComponent
      },
      {
        path: 'Home',
        component: HomePageComponent
      },
      {
        path: 'Profile',
        component: ProfileComponent
      },
      {
        path: 'One',
        component: OneComponent
      },
      {
        path: 'Two',
        component: TwoComponent
      }
    ])
  ],
  providers: [CommunicationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
