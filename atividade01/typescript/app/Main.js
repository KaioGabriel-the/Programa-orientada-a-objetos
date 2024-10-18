"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var readline_sync_1 = require("readline-sync");
var circulo_1 = require("../classe/circulo");
var retangulo_1 = require("../classe/retangulo");
var SituacaoFinaceira_1 = require("../classe/SituacaoFinaceira");
function enter() {
    var input = String((0, readline_sync_1.question)("APERTE ENTER..."));
}
function Main() {
    var menu = " ----- MENU ----- \n    1- RETANGULO\n    2- CIRCULO\n    3 - SITUA\u00C7\u00C3O FINACEIRA\n    0 - SAIR\n    \n";
    console.log(menu);
    var opcao = Number((0, readline_sync_1.question)("QUAL OPÇÃO DESEJA ACESSAR: "));
    console.clear();
    while (opcao !== 0) {
        if (opcao === 1) {
            var ladomaior = Number((0, readline_sync_1.question)("Digite o lado maior do retângulo: "));
            var ladomenor = Number((0, readline_sync_1.question)("Digite o lado menor do retângulo: "));
            var retangulo = new retangulo_1.Rentangulo(ladomaior, ladomenor);
            console.log("O per\u00EDmetro do ret\u00E2ngulo \u00E9 ".concat(retangulo.perimetro().toFixed(2)));
            enter();
        }
        else if (opcao === 2) {
            var menucirculo = " ----- MENU ----- \n1- \u00C1REA \n2- PERIMETRO\n";
            console.log(menucirculo);
            var opcaocirculo = Number((0, readline_sync_1.question)("Qual opção deseja: "));
            console.clear();
            var raio = Number((0, readline_sync_1.question)("Digite o raio: "));
            var circulo = new circulo_1.Circulo(raio);
            if (opcaocirculo == 1) {
                console.log("A \u00E1rea do ret\u00E2ngulo \u00E9 ".concat(circulo.area().toFixed(2)));
            }
            else if (opcaocirculo == 2) {
                console.log("O per\u00EDmetro do ret\u00E2ngulo \u00E9 ".concat(circulo.perimetro().toFixed(2)));
            }
            enter();
        }
        else if (opcao === 3) {
            var credito = Number((0, readline_sync_1.question)("Digite o valor do credito que você tem: "));
            var debito = Number((0, readline_sync_1.question)("Digite o valor do debito que você tem: "));
            var situacaofinaceira = new SituacaoFinaceira_1.SituacaoFinaceira(credito, debito);
            console.log("O saldo atual na sua conta \u00E9 ".concat(situacaofinaceira.calcularSaldo().toFixed(2)));
            enter();
        }
        console.clear();
        console.log(menu);
        opcao = Number((0, readline_sync_1.question)("QUAL OPÇÃO DESEJA ACESSAR: "));
        console.clear();
    }
    console.log("OBRIGADO POR USAR NOSSO SISTEMA.");
}
Main();
