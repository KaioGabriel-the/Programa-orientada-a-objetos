"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Rentangulo = void 0;
var Rentangulo = /** @class */ (function () {
    function Rentangulo(ladomaior, ladomenor) {
        this.ladomaior = ladomaior;
        this.ladomenor = ladomenor;
    }
    Rentangulo.prototype.perimetro = function () {
        var result = 2 * (this.ladomaior + this.ladomenor);
        return result;
    };
    return Rentangulo;
}());
exports.Rentangulo = Rentangulo;
