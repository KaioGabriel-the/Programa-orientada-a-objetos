export class ControleAudio{
    private volume: number = 5;

    public getVolume(): number{
       return this.volume;
    }
    
    private limiteVolume(volume:number){

        if(volume < 0){
            return 0;
        }else if(volume > 10){
            return 10;
        }

        return volume
    }

    public aumentar():number{
        this.volume = this.limiteVolume(this.getVolume() +1);
        return this.volume;
    }

    public diminur(): number{
        this.volume = this.limiteVolume(this.getVolume() - 1);
        return  this.volume;
    }

    public lerVolume(){
        return this.volume;
    }

}