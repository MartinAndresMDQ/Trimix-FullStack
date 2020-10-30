
import { throwError as observableThrowError, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/Rx';
import { catchError, map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Persona } from '../../@model/persona';
// import { ErrorHandler } from '@model';


@Injectable()
export class PersonaService {

    constructor(private _httpService: HttpClient) { }

private URL="http://localhost:8080/trimix-Backend"
  public options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    //   'Access-Control-Allow-Origin': '*',
      // 'Authorization': 'Bearer ' + this.token.access_token
    })
  };

    // getAllPersonas(): Observable<Persona[]> {
    //     return this._httpService.get<Persona[]>(this.URL+"/api/personas",this.options)
    //         .pipe(map(response => {
    //             return response;
    //         }),
    //             catchError(this.handleError)
    //         );
    // }

    getAllPersonasTipo(tipo:string,pagina:number,cantidad): Observable<Persona[]> {
        return this._httpService.get<Persona[]>(this.URL+"/api/personas/"+tipo +"/"+pagina +"/"+cantidad,this.options)
            .pipe(map(response => {
                return response;
            }),
                catchError(this.handleError)
            );
    }

    getAllPersonasNombreTipo(nombre:string,tipo:string,pagina:number,cantidad): Observable<Persona[]> {
        return this._httpService.get<Persona[]>(this.URL+"/api/personas/"+tipo+"/"+nombre +"/"+pagina +"/"+cantidad,this.options)
            .pipe(map(response => {
                return response;
            }),
                catchError(this.handleError)
            );
    }

    getAllPersonasCantNombreTipo(nombre:string,tipo:string): Observable<Number> {
        return this._httpService.get<Number>(this.URL+"/api/personasCant/"+tipo+"/"+nombre,this.options)
            .pipe(map(response => {
                return response;
            }),
                catchError(this.handleError)
            );
    }


    getAllPersonasCantTipo(tipo:string): Observable<Number> {
        return this._httpService.get<Number>(this.URL+"/api/personasCant/"+tipo,this.options)
            .pipe(map(response => {
                return response;
            }),
                catchError(this.handleError)
            );
    }


    getPersonaById(PersonaId: string): Observable<Persona> {
        console.log("Inside the getPersonaById() service::::::");
        return this._httpService.get<Persona>(this.URL+"/api/persona/" + PersonaId,this.options)

            .pipe(map(response => {
                return response;
            }),
                catchError(this.handleError)
            );
        // .map((response: Response) => response.json())
        // .catch(this.handleError);
    }

    addPersona(persona: Persona) {
        let body = JSON.parse(JSON.stringify(persona));
        let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        let options = { headers: headers };
        if (persona.perId!=0) {
            console.log("Inside addPersona update service():::::::");
            return this._httpService.put(this.URL+"/api/persona/" + persona.perId, body, this.options)
            .pipe(
                catchError(this.handleError)
            );;
        } else {
            console.log("Inside addPersona add service():::::::");
            return this._httpService.post(this.URL+"/api/persona", body, this.options)
            .pipe(
                catchError(this.handleError)
            );;
        }
    }

    deletePersona(PersonaId: string) {
        console.log("Inside the service deletePersona():::::Persona id:::" + PersonaId);
        return this._httpService.delete(this.URL+"/api/persona/" + PersonaId,this.options)
        .pipe(
            catchError(this.handleError)
        );;
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error);
    }
}