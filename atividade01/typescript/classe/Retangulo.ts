export class Rentangulo {
    
    ladomaior: number;
    ladomenor: number;

    constructor(ladomaior: number, ladomenor){
        this.ladomaior = ladomaior;
        this.ladomenor = ladomenor;
    }

    public perimetro(): number{
        const result = 2 * (this.ladomaior + this.ladomenor);
        return result;
    }
    //Novo método criado
    public ehQuadrado():String{
        return this.ladomaior === this.ladomenor ? "True" : "False";
    }
}