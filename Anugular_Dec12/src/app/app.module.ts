import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

// material imports
import {
  MatToolbarModule,
  MatExpansionModule,
  MatInputModule,
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatOptionModule,
  MatSelectModule,
  MatDialogModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MAT_DATE_LOCALE,
  MAT_DATE_FORMATS,
  DateAdapter,
  MAT_NATIVE_DATE_FORMATS,
  MatGridList,
  MatGridListModule,
  MatSidenavModule,
  MatGridTile,
  MatTableModule,
  MatGridTileText
} from '@angular/material';

// components inports
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';

// services imports
import { AuthenticationService } from './services/authentication.service';
import { RouterService } from './services/router.service';
import { WorkflowServiceService } from './services/workflow-service.service';
// guards imports
import { CanActivateRouteGuard } from './can-activate-route.guard';
import { HomeComponent } from './home/home.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { EditComponent } from './edit/edit.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';

// custom routes
const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    //canActivate: [CanActivateRouteGuard]
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'edit',
    component: EditComponent,
  }
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,
    EditComponent,
    MenuComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule,
    MatToolbarModule,
    MatExpansionModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    //MatIconModule,
    MatOptionModule,
    MatSelectModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatGridListModule,
    //MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatTableModule,
    BrowserModule, FormsModule, FlexLayoutModule, BrowserAnimationsModule,
    MatIconModule, MatButtonModule, MatSidenavModule, MatToolbarModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    RouterService,
    AuthenticationService,
    CanActivateRouteGuard,
    WorkflowServiceService
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
