"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.SituacaoFinaceira = void 0;
var SituacaoFinaceira = /** @class */ (function () {
    function SituacaoFinaceira(credito, debito) {
        this.valorCreditos = credito;
        this.valorDebitos = debito;
    }
    SituacaoFinaceira.prototype.calcularSaldo = function () {
        return this.valorCreditos - this.valorDebitos;
    };
    return SituacaoFinaceira;
}());
exports.SituacaoFinaceira = SituacaoFinaceira;
