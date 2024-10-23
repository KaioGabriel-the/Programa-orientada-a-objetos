"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ControleAudio = void 0;
var ControleAudio = /** @class */ (function () {
    function ControleAudio(volume) {
        this.volume = 5;
        this.volume = volume;
    }
    ControleAudio.prototype.getVolume = function (ajustar) {
        if (ajustar === void 0) { ajustar = 0; }
        var volumenovo = this.volume + ajustar;
        if (volumenovo < 0) {
            return 0;
        }
        else if (volumenovo > 10) {
            return 10;
        }
        return volumenovo;
    };
    ControleAudio.prototype.aumentar = function () {
        this.volume = this.getVolume(1);
        return this.volume;
    };
    ControleAudio.prototype.diminur = function () {
        this.volume = this.getVolume(-1);
        return this.volume;
    };
    ControleAudio.prototype.lerVolume = function () {
        return this.volume;
    };
    return ControleAudio;
}());
exports.ControleAudio = ControleAudio;
