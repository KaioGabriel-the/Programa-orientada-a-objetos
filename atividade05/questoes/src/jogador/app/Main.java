package jogador.app;
import jogador.entities.Jogador;

public class Main {

    public static void main(String[] args){
        Jogador jogador01 = new Jogador(0,10,100);
        Jogador jogador02 = new Jogador(0,10,100);

        System.out.println(jogador01.toString());
        System.out.println(jogador02.toString());
        jogador01.ataque(jogador02);
        System.out.println(jogador01.toString());
    }
}
