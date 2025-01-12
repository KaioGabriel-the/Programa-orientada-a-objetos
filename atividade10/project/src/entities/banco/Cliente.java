package entities.banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private static int _id;
    private String _nome;
    private String _cpf;
    private Date _dataNascimento;
    private List<Conta> _contas;

    public Cliente(String nome, String cpf, Date dataNascimento) {
        _id = 0;
        _id++;
        _nome = nome;
        _cpf = cpf;
        _dataNascimento = new Date();
        _contas = new ArrayList<Conta>();
    }

    public static int get_id() {
        return _id;
    }


}
