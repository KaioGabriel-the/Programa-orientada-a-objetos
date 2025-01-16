package entities.banco;

public class ContaImposto extends Conta{
    private double _taxaimposto = 0.38/100;

    public ContaImposto(String numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void sacar(double valor) {
        valor += valor * _taxaimposto;
        super.sacar(valor);
    }

}
