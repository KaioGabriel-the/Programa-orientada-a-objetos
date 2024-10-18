"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Circulo = void 0;
var Circulo = /** @class */ (function () {
    function Circulo(raio) {
        this.raio = raio;
    }
    Circulo.prototype.area = function () {
        return Math.pow(this.raio, 2) * Math.PI;
    };
    Circulo.prototype.perimetro = function () {
        return 2 * this.raio * Math.PI;
    };
    return Circulo;
}());
exports.Circulo = Circulo;
