package entities;

public class Conta {
    private static int nextId = 0;
    private int id;
    private int numeroConta;
    private float saldo;
    private Cliente cliente;

    public Conta(int numeroConta, float saldo) {
        this.id = nextId;
        nextId++;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = null;
    }

    public boolean sacar(float valor) {

        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }

        return false;
    }

    private Cliente getCliente() { return this.cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    private int getId() { return this.id; }

    private float getSaldo() {return saldo;}

    private int getNumeroConta() {return numeroConta;}

    @Override
    public String toString() {
        return "Conta( " + getId() + " ) \n" + "Numero da conta: " + numeroConta +"\nSaldo: R$ " + saldo + "\nCliente: " + cliente + "\n";
    }
}
