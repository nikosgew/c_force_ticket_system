import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { AppRoutingModule } from './/app-routing.module';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        TicketsComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        HttpClientModule,
        AppRoutingModule
    ],
    providers: [],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}