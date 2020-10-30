import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { PersonaService } from '@services';
import { Persona } from '@model';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';

@Component({
    selector: 'new-persona',
    templateUrl: './newPersona.component.html',
    styleUrls: ['./newPersona.component.css']
})
export class NewPersonaComponent implements OnInit {

    // personas: Persona[];
    statusMessage: string;
    persona = new Persona();
    lista:string[]=["DNI","Pasaporte", "Cedula"];

    myForm: FormGroup;

    constructor(private _PersonaService: PersonaService,
        private _router: Router,
        private _route: ActivatedRoute,public fb: FormBuilder
        ) {

            this.myForm = this.fb.group({
                perNombre: ['', [Validators.required,Validators.minLength(3)]],
                perApellido: ['', [Validators.required,Validators.minLength(3)]],
                perNumeroDocumento: ['', [Validators.required,Validators.min(1000000),Validators.max(999999999)]],
                perTipoDocumento: ['DNI', [Validators.required]],
                perFechaNacimiento: [new Date(), [Validators.required]],
                // password: ['', [Validators.required]],
              });
    }

    ngOnInit(): void {

        this._route.params.forEach((params: Params) => {
            let idPer = params['id'];
            // console.log(params['id'])
            if(idPer)
            this.getPersona(idPer);
            else{
                
        //   this.myForm = this.fb.group({
        //     perNombre: ['', [Validators.required,Validators.minLength(3)]],
        //     perApellido: ['', [Validators.required,Validators.minLength(3)]],
        //     perNumeroDocumento: ['', [Validators.required,Validators.minLength(7),Validators.minLength(9)]],
        //     perTipoDocumento: ['DNI', [Validators.required]],
        //     perFechaNacimiento: [new Date(), [Validators.required]],
        //     // password: ['', [Validators.required]],
        //   });
            }
            
        });

        // console.log("calling ngOnInit()::::");
        // this.getPersonas();
    }

    // getPersonas(): void{
    //     console.log("Inside getPersonas():::::")
    //     this._PersonaService.getAllPersonas()
    //         .subscribe((PersonaData) => this.personas = PersonaData,
    //         (error) =>{
    //             console.log(error);
    //             this.statusMessage = "Problem with service. Please try again later!";
    //         }
    //     );
    //     console.log("end of getPersonas():::::");
    // }

    guardar(): void {
        console.log("inside the addPersona()::::::")
        console.log(this.persona)
        this._PersonaService.addPersona(this.persona)
            .subscribe((response) => {
                console.log(response);
                // this.getPersonas();
                this.volver();
            },
                (error) => {
                    console.log(error);
                    this.statusMessage = "Problem with service. Please try again later!";
                }
            );

        console.log("end of addPersona()::::");
        //this._router.navigate(['/Personas']);
    }

    // private reset() {
    //     console.log("inside the reset():::::::");
    //     this.persona = new Persona();
    //     console.log("end of reset():::::::");
    // }

    // ngOnChanges(changes:any) {
    //     console.log("calling ngOnChanges()::::::::");
    // }

    // deletePersona(PersonaId: string){
    //     console.log("Inside the deletePersona()::::Persona id::::"+PersonaId);
    //     this._PersonaService.deletePersona(PersonaId)
    //         .subscribe((response) => {console.log(response); 
    //             // this.getPersonas();
    //         },
    //         (error) =>{
    //             console.log(error);
    //             this.statusMessage = "Problem with service. Please try again later!";
    //         });
    //         this.reset();
    //         console.log("end of deletePersona():::::::");
    // }

    getPersona(PersonaId: string) {
        // console.log("Inside the updatePersona()::::::Persona id::::"+PersonaId);
        this._PersonaService.getPersonaById(PersonaId)
            .subscribe((PersonaData) => {
                this.persona = PersonaData;
                console.log(PersonaData)
                this.persona.perFechaNacimiento = new Date(PersonaData.perFechaNacimiento)
                // console.log(this.persona)

                
          this.myForm = this.fb.group({
            perNombre: [this.persona.perNombre, [Validators.required,Validators.minLength(3)]],
            perApellido: [this.persona.perApellido, [Validators.required,Validators.minLength(3)]],
            perNumeroDocumento: [this.persona.perNumeroDocumento, [Validators.required,Validators.min(1000000),Validators.max(999999999)]],
            perTipoDocumento: [this.persona.perTipoDocumento, [Validators.required]],
            perFechaNacimiento: [this.persona.perFechaNacimiento, [Validators.required]],
            // password: ['', [Validators.required]],
          });
                // this.getPersonas();
            }),
            (error) => {
                console.log(error);
                this.statusMessage = "Problem with service. Please try again later!";
            }
        // this.reset();
        // console.log("end of updatePersona()::::::");
    }

    volver(){
        this._router.navigate(['/personas/todos' ]);
    }
    selectDate(event){
        this.persona.perFechaNacimiento=new Date(event);
        this.persona.perFechaNacimiento.setDate(this.persona.perFechaNacimiento.getDate() + 1);
        // console.log()
    }
}