package banco.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    int id;
    String nome;
    String cpf;
    Date dataNascimento;
    List<Conta> contas;

    public Cliente(int id, String nome, String cpf, String dataNascimentoStr, List<Conta> contas) throws ParseException {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;

        // Cria o SimpleDateFormat com o formato de data desejado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataNascimento = sdf.parse(dataNascimentoStr); // Converte a string para um objeto Date
        this.contas = new ArrayList<>(contas);
    }

    public List<Conta> getContas() {
        return contas;
    }


}
