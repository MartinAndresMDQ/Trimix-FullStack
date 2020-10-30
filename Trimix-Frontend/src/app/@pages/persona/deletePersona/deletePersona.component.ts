
import { Component, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { PersonaService } from '@services';

@Component({
  selector: 'delete-persona',
  template: `
  <div class="modal-header">
  <h4 class="modal-title" id="modal-title">Eliminar Persona</h4>
    <button type="button" class="close" aria-label="Close button" aria-describedby="modal-title" (click)="modal.dismiss('Cross click')">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="modal-body">
    <p><strong>Desea eliminar a {{name}} de la Base?</strong></p>
  </div>
  <div class="modal-footer">
    <button type="button" class="btn btn-outline-secondary" (click)="modal.dismiss('cancel')">Cancel</button>
    <button type="button" ngbAutofocus class="btn btn-danger" (click)="modal.close('Ok')">Ok</button>
  </div>
  `
})
export class DeletePersonaComponent {
    @Input() name;
  constructor(public modal: NgbActiveModal) {}


}