export class SituacaoFinaceira {
    valorCreditos: number;
    valorDebitos: number;

    constructor(credito: number, debito: number) {
        this.valorCreditos = credito;
        this.valorDebitos = debito;
    }

    calcularSaldo(): number{
        return this.valorCreditos - this.valorDebitos;
    }
}