import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewPersonaComponent } from '@pages/persona/newPersona';
import { PersonaListComponent } from '@pages/persona/personas';
import { PageNotFoundComponent } from './others/pageNotFound.component';
// import { HomeComponent } from './persona/home.component';
// import { PersonaComponent } from './persona/persona.component';
// import { PersonaListComponent } from './persona/personas.component';

const routes: Routes = [
// { path: 'home', component: HomeComponent },
{ 
  path: 'personas', 
  loadChildren: () => import('./@pages/persona/persona.module').then(m => m.PersonaModule)
},
{ path: '', redirectTo: '/personas/todos', pathMatch: 'full' },
{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
