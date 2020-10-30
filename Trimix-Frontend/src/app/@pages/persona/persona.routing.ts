import { Routes, RouterModule } from '@angular/router';


import { NgModule } from '@angular/core';
import { PersonaComponent } from './persona.component';
import { PageNotFoundComponent } from 'src/app/others/pageNotFound.component';
import { NewPersonaComponent } from './newPersona';
import { PersonaListComponent } from './personas';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: PersonaComponent,
    children: [
      { path: 'todos', component: PersonaListComponent },
      { path: 'nueva', component: NewPersonaComponent },
      { path: 'editar/:id', component: NewPersonaComponent },
      { path: '', redirectTo: '/todos', pathMatch: 'full' },
      { path: '**', component: PageNotFoundComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PersonaRoutingModule { }