import { question } from 'readline-sync';
import { Circulo } from '../classe/circulo';
import { Rentangulo } from '../classe/retangulo';
import { SituacaoFinaceira } from '../classe/SituacaoFinaceira';

function enter(): void{
    const input = String(question("APERTE ENTER..."));
}
function Main(){
    const menu = ` ----- MENU ----- 
    1- RETANGULO
    2- CIRCULO
    3 - SITUAÇÃO FINACEIRA
    0 - SAIR
    \n`;
    console.log(menu);

    let opcao = Number(question("QUAL OPÇÃO DESEJA ACESSAR: "));
    console.clear();

    while(opcao !== 0){

        if (opcao === 1){
            const ladomaior = Number(question("Digite o lado maior do retângulo: "));
            const ladomenor = Number(question("Digite o lado menor do retângulo: "));
            const retangulo = new Rentangulo(ladomaior, ladomenor);

            console.log(`O perímetro do retângulo é ${retangulo.perimetro().toFixed(2)}`);
            enter();
        }else if(opcao === 2){
            const menucirculo = ` ----- MENU ----- \n1- ÁREA \n2- PERIMETRO\n`;
            console.log(menucirculo);

            const opcaocirculo = Number(question("Qual opção deseja: "));
            console.clear();

            const raio = Number(question("Digite o raio: "));

            const circulo = new Circulo(raio);

            if(opcaocirculo == 1){
                console.log(`A área do retângulo é ${circulo.area().toFixed(2)}`);
            }else if(opcaocirculo == 2){
                console.log(`O perímetro do retângulo é ${circulo.perimetro().toFixed(2)}`);
            }
            enter();
        }else if(opcao === 3){
            const credito = Number(question("Digite o valor do credito que você tem: "));
            const debito = Number(question("Digite o valor do debito que você tem: "));

            const situacaofinaceira = new SituacaoFinaceira(credito,debito);

            console.log(`O saldo atual na sua conta é ${situacaofinaceira.calcularSaldo().toFixed(2)}`);
            enter();
        }
        
        console.clear();
        console.log(menu);
        opcao = Number(question("QUAL OPÇÃO DESEJA ACESSAR: "));
        console.clear();
    }

    console.log("OBRIGADO POR USAR NOSSO SISTEMA.");
}

Main();