package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int nextId;
    public int id;
    public String nome;
    public String cpf;
    public String telefone;
    public String dataNascimento;
    List<Conta> contas;

    public Cliente(String nome, String cpf, String telefone, String dataNascimento) {
        this.id = nextId;
        nextId++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        contas = new ArrayList<Conta>();
    }

    public int getId() { return id; }

    public String getCpf() { return cpf;}

    public void setCpf(String cpf) { this.cpf = cpf;}

    public void setTelefone(String newTelefo){ this.telefone = telefone; }

    public List<Conta> getContas() { return contas; }

    public void setContas(Conta conta) { contas.add(conta); }
}
