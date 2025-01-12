package entities.banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private int _id;
    private String _nome;
    private String _cpf;
    private String _dataNascimento;
    private List<Conta> _contas;

    public Cliente(String nome, String cpf, String dataNascimento) {
        _id = 0;
        _nome = nome;
        _cpf = cpf;
        _dataNascimento = dataNascimento;
        _contas = new ArrayList<Conta>();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nome() {
        return _nome;
    }

    public String get_cpf() {
        return _cpf;
    }

    public void adicionaConta(Conta conta) {
        _contas.add(conta);
    }

    public List<Conta> copiaContas() {
        List<Conta> copiaContas = new ArrayList<>();

        for (Conta conta : _contas) {
            copiaContas.add(conta);
        }

        return copiaContas;
    }
}
