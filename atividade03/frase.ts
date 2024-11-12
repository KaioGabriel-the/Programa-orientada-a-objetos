class frase{
    
    public nome: string;
    public numero: number;
    public linguagem: string;

    constructor(nome: string, numero: number, linguagem: string){
        this.nome = nome;
        this.numero = numero;
        this.linguagem = linguagem;
    }

    printfrase(): void{
        console.log(`${this.nome} \nMy payment time is ${this.numero} \nand \nMy preffered language is ${this.linguagem}`);        
    }
}

function main(){
    const frase01 = new frase("Ely",120.56,"TypeScript");
    frase01.printfrase();
}

main();