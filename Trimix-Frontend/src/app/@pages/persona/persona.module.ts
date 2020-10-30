import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule as AngularFormsModule, FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PersonaRoutingModule } from './persona.routing';
import { PersonaComponent } from './persona.component';
import { NewPersonaComponent } from './newPersona';
import { PersonaListComponent } from './personas';
import { PersonaService } from '@services';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DeletePersonaComponent } from './deletePersona';
// import { DeletePersonaComponent } from './deletePersona/deletePersona.component';

@NgModule({
  imports: [
    CommonModule,
    AngularFormsModule,
    NgbModule,
    // HttpClientModule, 
    FormsModule,
    ReactiveFormsModule,
    PersonaRoutingModule
  ],
  declarations: [
    PersonaComponent,
    NewPersonaComponent,
    PersonaListComponent,
    DeletePersonaComponent
  ],
  // exports:[PersonaListComponent],
  entryComponents:[DeletePersonaComponent],
  providers: [PersonaService]
})
export class PersonaModule {
}