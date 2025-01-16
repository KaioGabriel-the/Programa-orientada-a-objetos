package entities.banco;

public class ContaDeposito extends Conta{
    String cpfResponsavel;

    public ContaDeposito(String nome,double saldo, String cpfResponsavel){
        super(nome,saldo);
        this.cpfResponsavel = cpfResponsavel;
    }
}
