package saudacao.app;

import saudacao.entities.Saudacao;

public class Main {

    public static void main(String[] args){
        Saudacao saudacao = new Saudacao("Bom dia","Kaio");
        saudacao.obterSaudacao();
    }
}
