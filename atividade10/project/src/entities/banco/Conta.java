package entities.banco;

public class Conta {
    private int _id;
    public String numero;
    public double saldo;
    public Cliente _cliente;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this._id = 0;
    }

    public int get_id() {
       return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_numero() {
        return numero;
    }

    public double get_saldo() {
        return saldo;
    }

    public Cliente get_cliente() {
        return _cliente;
    }

    public void set_cliente(Cliente cliente) {
        this._cliente = cliente;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(Conta destino, double valor) {
        this.saldo -= valor;
        destino.depositar(valor);
    }
}
