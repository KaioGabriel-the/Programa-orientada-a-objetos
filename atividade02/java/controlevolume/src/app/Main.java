package app;
import entities.ControleVolume;

public class Main {
    static public void main(String[] args){
        ControleVolume controleVolume = new ControleVolume();
        System.out.printf("Aumetar volume: %d", controleVolume.aumetar());
        System.out.printf("Diminur volume: %d", controleVolume.diminuir());
        System.out.printf("Volume atual: %d", controleVolume.lerVolume());
    }
}
