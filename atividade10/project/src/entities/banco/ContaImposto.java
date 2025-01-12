package entities.banco;

public class ContaImposto extends Conta{
    private double _taxaimposto;

    public ContaImposto(String numero, double saldo, double taxaimposto) {
        super(numero, saldo);
        _taxaimposto = taxaimposto;
    }

    @Override
    public void sacar(double valor) {
        valor += valor * _taxaimposto/100;
        super.sacar(valor);
    }

}
