import { Component, OnInit, Output, EventEmitter } from '@angular/core';
// import { PersonaService } from '../@services/persona/persona.service';
// import { Persona } from '../@model/persona';
import { Router } from '@angular/router';
import { Persona } from '@model';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { PersonaService } from '@services';
import { DeletePersonaComponent } from '../deletePersona';
// import { DeletePersonaComponent } from '../deletePersona/deletePersona.component';


@Component({
    selector: 'Persona-list',
    templateUrl: './personas.component.html',
    styleUrls: ['./personas.component.css']
})
export class PersonaListComponent implements OnInit {
    persona = new Persona();

    page = 1;
    // statusMessage: string;
    personas: Persona[];
    nombre = '';
    cantidad = 5;
    total: Number = 10;
    tipo = "Todas";
    lista: string[] = ["Todas", "DNI", "Pasaporte", "Cedula"];
    constructor(private _PersonaService: PersonaService,
        private _router: Router,
        private _modalService: NgbModal) { }

    ngOnInit(): void {
        console.log("calling ngOnInit()::::");
        this.buscar();
    }

    // getPersonas(): void {
    //     console.log("Inside getPersonas():::::")
    //     this._PersonaService.getAllPersonasTipo(this.tipo, this.page, this.cantidad)
    //         .subscribe((PersonaData) => this.personas = PersonaData,
    //             (error) => {
    //                 console.log(error);
    //             }
    //         );
    //     console.log("end of getPersonas():::::");
    // }

    buscar() {
        console.log(this.tipo)
        if (this.nombre == '') {

            this._PersonaService.getAllPersonasCantTipo(this.tipo)
                .subscribe((cantidad) => {
                    this.total = cantidad;
                    this._PersonaService.getAllPersonasTipo(this.tipo, this.page, this.cantidad)
                        .subscribe((PersonaData) => this.personas = PersonaData,
                            (error) => {
                                console.log(error);
                            }
                        );
                }, //this.personas = PersonaData,
                    (error) => {
                        console.log(error);
                    }
                );

        }
        else {
            this._PersonaService.getAllPersonasCantNombreTipo(this.nombre, this.tipo)
                .subscribe((cantidad) => {
                    this.total = cantidad;
                    this._PersonaService.getAllPersonasNombreTipo(this.nombre, this.tipo, this.page, this.cantidad)
                        .subscribe((PersonaData) => this.personas = PersonaData,
                            (error) => {
                                console.log(error);
                            }
                        );
                },
                    (error) => {
                        console.log(error);
                    }
                );
        }
    }

    ver(idPer) {
        // console.log(this.tipo)

        this._router.navigate(['/personas/editar', idPer]);
    }


    openDelete(persona: Persona) {
        let modal: NgbModalRef = this._modalService.open(DeletePersonaComponent);
        modal.componentInstance.name = persona.perNombre;
        modal.result.then((data) => {
            // on close
            if (data == 'Ok') {

                this._PersonaService.deletePersona(persona.perId.toString())
                    .subscribe((response) => {
                        console.log(response);
                        this.buscar();
                    },
                        (error) => {
                            console.log(error);
                        });

            }
            console.log(data);
        }, (reason) => {
            // on dismiss
        });
        // console.log(modal.componentInstance)
    }

    cambiarPagina(event) {
        this.page = event;
        this.buscar();
    }
}