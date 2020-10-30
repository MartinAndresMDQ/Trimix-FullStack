import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
// import { HomeComponent } from './persona/home.component';
// import { PersonaComponent } from './persona/persona.component';
// import { PersonaListComponent } from './persona/personas.component';
// import { PersonaService } from './@services/persona/persona.service';
// import { NewPersonaComponent } from '@pages/persona/newPersona';
// import { PersonaListComponent } from '@pages/persona/personas';

@NgModule({
  declarations: [
    AppComponent,
    // NewPersonaComponent,
    // PersonaListComponent
  ],
  imports: [
    BrowserModule, 
    ReactiveFormsModule,
    HttpClientModule, 
    FormsModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
