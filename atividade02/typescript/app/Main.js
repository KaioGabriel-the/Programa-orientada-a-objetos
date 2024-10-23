"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ControleAudio_1 = require("../classes/ControleAudio");
function main() {
    var controleaudio = new ControleAudio_1.ControleAudio(5);
    console.log("DIMINUIR VOLUME: ".concat(controleaudio.diminur()));
    console.log("AUMENTAR VOLUME: ".concat(controleaudio.aumentar()));
    console.log("VOLUME ATUAL: ".concat(controleaudio.lerVolume()));
}
main();
