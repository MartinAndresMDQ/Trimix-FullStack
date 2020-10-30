export class Persona{
    public perId: number;
    public perFechaNacimiento: Date;
    public perApellido: string;
    public perNombre: string;
    public perNumeroDocumento: number;
    public perTipoDocumento: string;
    constructor(
        perId?: number,
        perFechaNacimiento?: Date,
        perApellido?: string,
        perNombre?: string,
        perNumeroDocumento?: number,
        perTipoDocumento?: string){
            this.perId=perId || 0;
            this.perFechaNacimiento=perFechaNacimiento || new Date();
            this.perApellido=perApellido || "";
            this.perNombre=perNombre || "";
            this.perNumeroDocumento=perNumeroDocumento || 0;
            this.perTipoDocumento=perTipoDocumento || "DNI";
        
    }
}