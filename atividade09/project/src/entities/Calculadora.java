package entities;

public class Calculadora {

    private int operacion1;
    private int operacion2;

    public Calculadora(int operacion1, int operacion2) {
        this.operacion1 = operacion1;
        this.operacion2 = operacion2;
    }

    public int somar() {
        return operacion1 + operacion2;
    }

    public int subtrair() {
        return operacion1 - operacion2;
    }
}
