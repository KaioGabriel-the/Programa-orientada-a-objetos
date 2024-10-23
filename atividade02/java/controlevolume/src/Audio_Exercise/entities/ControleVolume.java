package Audio_Exercise.entities;

public class ControleVolume {
    private int volume = 5;

    public int getVolume(){
        return volume;
    }

    private int limiteVolume(int volumeatual){
        if(volumeatual < 0){
            return 0;
        } else if (volumeatual > 10) {
            return 10;
        }
        return volumeatual;
    }

    public int aumetar(){
        volume = limiteVolume(getVolume() +1);
        return volume;
    }

    public int diminuir(){
      volume = limiteVolume(getVolume() -1);
      return volume;
    }

    public int lerVolume(){
        return getVolume();
    }

}
