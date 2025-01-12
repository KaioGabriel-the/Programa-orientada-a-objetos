package entities.calculadora;

public class CalculadoraCm {
    protected double numeroum;
    protected double numerodois;

    public CalculadoraCm(double numeroum, double numerodois) {
        this.numeroum = numeroum;
        this.numerodois = numerodois;
    }

    public void somar(){
        double soma = numeroum + numerodois;
        System.out.println("O resuldato da somar é "+ soma);
    }

    public void subtrair(){
        double subtracao = numeroum - numerodois;
        System.out.println("O resuldado da subtração é " + subtracao);
    }

    public void multiplicar(){
        double multiplicacao = numeroum * numerodois;
        System.out.println("O resultado da multiplicação é " + multiplicacao);
    }

    public void dividir(){
        double divisao = numeroum / numerodois;
        System.out.println("O resultado da divisão é " + divisao);
    }
}
