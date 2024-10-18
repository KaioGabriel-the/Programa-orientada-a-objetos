export class Rentangulo {
    
    ladomaior: number;
    ladomenor: number;

    constructor(ladomaior: number, ladomenor){
        this.ladomaior = ladomaior;
        this.ladomenor = ladomenor;
    }

    perimetro(): number{
        const result = 2 * (this.ladomaior + this.ladomenor);
        return result;
    }
}