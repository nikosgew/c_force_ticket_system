// ANGULAR
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';




// EXTERNAL



// OWN
import { GaugeComponent } from './gauge.component';





@NgModule({
  declarations: [
    GaugeComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [],
  bootstrap: [
    GaugeComponent
  ],
  exports: [
    GaugeComponent
  ]
})
export class GaugeModule { }