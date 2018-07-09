import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tickets', component: TicketsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }



];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  declarations: []
})


export class AppRoutingModule { }
