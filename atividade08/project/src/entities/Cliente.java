package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int nextId;
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;
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

    private int getId() { return id; }

    private String getCpf() { return cpf;}

    public void setCpf(String cpf) { this.cpf = cpf;}

    public void setTelefone(String newTelefo){ this.telefone = telefone; }

    private List<Conta> getContas() { return contas; }

    public void setContas(Conta conta) { contas.add(conta); }

    @Override
    public String toString() {
        return "Cliente( " + id +" ) \n" + "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Telefone: " + telefone + "Data de nascimento: " + dataNascimento ;
    }
}
