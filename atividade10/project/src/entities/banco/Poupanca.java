package entities.banco;

public class Poupanca extends Conta {
    private double _taxaJuros;
    public Poupanca(String numero, double saldo, double taxaJuros) {
        super(numero, saldo);
        _taxaJuros = taxaJuros;
    }

    public double renderJuros() {
        double juros = saldo * _taxaJuros/100;
        return juros;
    }
}
