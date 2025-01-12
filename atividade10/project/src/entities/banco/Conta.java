package entities.banco;

public class Conta {
    private static int _id;
    private String _numero;
    public float _saldo;

    public Conta(String numero, float saldo) {
        this._id = 0;
        _id++;
        this._numero = numero;
        this._saldo = saldo;
    }

    public static int get_id() {
        return _id;
    }

    public String get_numero() {
        return _numero;
    }

    public float get_saldo() {
        return _saldo;
    }

}
