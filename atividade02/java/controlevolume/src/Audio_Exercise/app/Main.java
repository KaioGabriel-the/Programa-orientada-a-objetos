package Audio_Exercise.app;
import Audio_Exercise.entities.ControleVolume;

public class Main {
    static public void main(String[] args){
        ControleVolume controleVolume = new ControleVolume();
        System.out.printf("Aumetar volume: %d \n", controleVolume.aumetar());
        System.out.printf("Diminur volume: %d \n", controleVolume.diminuir());
        System.out.printf("Volume atual: %d \n", controleVolume.lerVolume());
    }
}
