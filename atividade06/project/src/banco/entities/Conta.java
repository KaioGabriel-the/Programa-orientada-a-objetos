package banco.entities;

public class Conta {
    int id;
    String numero;
    float saldo;
    Cliente cliente;

    public Conta(String numero, float saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public boolean sacar(float valor){
        if ( valor > saldo ){
            System.out.println("O valor do saque maior que o saldo");
            return false;
        }else {
            saldo -= valor;
            System.out.println("Saque realizado");
            return true;
        }
    }

    public void depositar(float deposito){
        saldo += deposito;
        System.out.println("Dinheiro depositado com sucesso");
    }

    public void transferir(Conta contaDestino, float valor) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
        } else {
            System.out.println("Não é possivel tranferir");
        }
    }
}
