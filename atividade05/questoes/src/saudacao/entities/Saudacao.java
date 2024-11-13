package saudacao.entities;

public class Saudacao {

    public String text;
    public String name;

    public Saudacao(String text, String name){
        this.text = text;
        this.name = name;
    }

    public void obterSaudacao(){
        System.out.println(text + "," + name);
    }
}
