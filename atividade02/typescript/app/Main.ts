import { ControleAudio } from "../entites/ControleAudio";

function main(){
    const controleaudio = new ControleAudio();
    console.log(`DIMINUIR VOLUME: ${controleaudio.diminur()}`);
    console.log(`AUMENTAR VOLUME: ${controleaudio.aumentar()}`);
    console.log(`VOLUME ATUAL: ${controleaudio.lerVolume()}`);
}

main();