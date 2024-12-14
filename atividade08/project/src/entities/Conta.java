package entities;

public class Conta {
    private int nextId = 0;
    private int id;
    public int numeroConta;
    public float saldo;
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
    public Cliente getCliente() { return this.cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public int getId() { return this.id; }

    public float getSaldo() {return saldo;}

    public int getNumeroConta() {return numeroConta;}
}
