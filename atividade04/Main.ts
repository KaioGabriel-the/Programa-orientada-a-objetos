function par(numero: number){
    return numero % 2 == 0 ? true : false;
}

function sitacao(nome: string, pronome: string = "Sr"): void{
    console.log(`${pronome}.${nome}`);
}

function numeroSeparadosPotTraco(array: number[]): string {
    let resultado ="";

    array.forEach((numero,index) => {
        if(index === array.length -1){
            resultado += numero;
        }else{
            resultado += numero + "-";
        }
    });

    return resultado;
}

function exibir(...palavras : string[]): void{
    let resultado = "";

    palavras.forEach((palavra,index) => {
        if(index === palavras.length -1){
            resultado += palavra;
        }else{
            resultado += "-";
        }
    })

    console.log(resultado);
}

const hi = () => {console.log("Olá");};
const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
const pares = array.filter((elemento) => elemento % 2 === 0);
const dobrar = array.map((numero) => numero * 2);
const somatorio = array.reduce((acumulador, numero) => acumulador + numero,0);