package banco.entities;  // Declara o pacote 'banco.entities', onde a classe Cliente está localizada

import java.text.ParseException;  // Importa a classe ParseException para capturar erros de formatação de data
import java.text.SimpleDateFormat;  // Importa a classe SimpleDateFormat para formatar e analisar datas
import java.util.ArrayList;  // Importa a classe ArrayList para criar listas dinâmicas
import java.util.Date;  // Importa a classe Date para representar datas
import java.util.List;  // Importa a interface List para criar listas de objetos

/**
 * <h2>Classe Cliente</h2>
 * <p>Classe que representa um cliente bancário, com informações pessoais e a lista de contas associadas a ele.</p>
 */
public class Cliente {

    /**
     * <h3>ID do Cliente</h3>
     * <p>Identificador único do cliente no sistema bancário.</p>
     */
    int id;

    /**
     * <h3>Nome do Cliente</h3>
     * <p>Nome completo do cliente.</p>
     */
    String nome;

    /**
     * <h3>CPF do Cliente</h3>
     * <p>Cadastro de Pessoa Física (CPF) do cliente.</p>
     */
    String cpf;

    /**
     * <h3>Data de Nascimento do Cliente</h3>
     * <p>Data de nascimento do cliente, representada como um objeto Date.</p>
     */
    Date dataNascimento;

    /**
     * <h3>Lista de Contas</h3>
     * <p>Lista de contas bancárias associadas ao cliente.</p>
     */
    List<Conta> contas;

    /**
     * <h2>Construtor da classe Cliente</h2>
     * <p>Inicializa um cliente com as informações fornecidas, incluindo a data de nascimento que é convertida de uma string para um objeto Date.</p>
     * @param id O identificador único do cliente.
     * @param nome O nome completo do cliente.
     * @param cpf O CPF do cliente.
     * @param dataNascimentoStr A data de nascimento do cliente em formato de string (dd/MM/yyyy).
     * @throws ParseException Se ocorrer um erro ao tentar converter a string de data para o objeto Date.
     */
    public Cliente(int id, String nome, String cpf, String dataNascimentoStr) throws ParseException {
        this.id = id;  // Inicializa o ID do cliente
        this.nome = nome;  // Inicializa o nome do cliente
        this.cpf = cpf;  // Inicializa o CPF do cliente

        // Cria um objeto SimpleDateFormat para analisar a string de data no formato "dd/MM/yyyy"
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Converte a string de data para um objeto Date
        this.dataNascimento = sdf.parse(dataNascimentoStr);

        // Inicializa a lista de contas como uma nova lista vazia
        this.contas = new ArrayList<>();
    }

    /**
     * <h2>Método getCpf</h2>
     * <p>Retorna o CPF do cliente.</p>
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return cpf;  // Retorna o CPF do cliente
    }

    /**
     * <h2>Método getId</h2>
     * <p>Este método retorna o identificador único da conta bancária.</p>
     * @return O ID da conta, representado por um número do tipo inteiro (int).
     */
    public int getId() {
        return id;  // Retorna o ID da conta
    }

}
