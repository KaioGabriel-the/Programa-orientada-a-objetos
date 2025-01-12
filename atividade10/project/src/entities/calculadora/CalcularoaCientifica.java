package entities.calculadora;

public class CalcularoaCientifica extends CalculadoraCm{

    public CalcularoaCientifica(double numeroum, double numerodois) {
        super(numeroum, numerodois);
    }

    public void pontecia(){
        double potencia = Math.pow(numeroum,numerodois);
        System.out.println("O resultado da potencia é " + potencia);
    }
}
