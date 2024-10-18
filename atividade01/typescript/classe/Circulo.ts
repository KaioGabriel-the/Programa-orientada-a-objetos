export class Circulo{
    raio: number;

    constructor(raio: number){
        this.raio = raio;
    }

    area(): number{
        return this.raio**2 * Math.PI;
    }

    perimetro(): number{
        return 2 * this.raio * Math.PI;
    }
}