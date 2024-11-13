package triangulo.app;

import triangulo.entities.Classificacao;

public class Main {
    public static void main(String[] args){
        Classificacao classificacao = new Classificacao(5, 5, 7);
        classificacao.ehTriangulo();
        classificacao.ehIsoceles();
        classificacao.ehEquilatero();
        classificacao.ehEscaleno();
    }
}
