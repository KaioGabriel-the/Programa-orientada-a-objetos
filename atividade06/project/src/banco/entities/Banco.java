package banco.entities;  // Declara o pacote 'banco.entities', onde a classe Banco está localizada

import java.util.ArrayList;  // Importa a classe ArrayList para utilizar listas dinâmicas
import java.util.List;  // Importa a interface List para criar listas de objetos
import java.util.stream.Collectors;

/**
 * <h2>Classe Banco</h2>
 * <p>Classe responsável por gerenciar as contas e clientes de um banco, com métodos para inserir, consultar e associar clientes às contas.</p>
 */
public class Banco {

    /**
     * <h3>Lista de contas</h3>
     * <p>Armazena todas as contas associadas ao banco.</p>
     */
    List<Conta> contaList;

    /**
     * <h3>Lista de clientes</h3>
     * <p>Armazena todos os clientes do banco.</p>
     */
    List<Cliente> clienteList;

    /**
     * <h2>Construtor da classe Banco</h2>
     * <p>Inicializa as listas de contas e clientes do banco.</p>
     */
    public Banco() {
        this.contaList = new ArrayList<>();  // Cria uma nova lista de contas
        this.clienteList = new ArrayList<>();  // Cria uma nova lista de clientes
    }

    /**
     * <h2>Método inserirConta</h2>
     * <p>Adiciona uma nova conta à lista de contas do banco.</p>
     * @param conta A conta a ser adicionada à lista de contas.
     */
    public void inserirConta(Conta conta) {
        contaList.add(conta);  // Adiciona a conta recebida ao banco de dados
    }

    /**
     * <h2>Método inserirCliente</h2>
     * <p>Adiciona um novo cliente à lista de clientes do banco.</p>
     * @param cliente O cliente a ser adicionado à lista de clientes.
     */
    public void inserirCliente(Cliente cliente) {
        clienteList.add(cliente);  // Adiciona o cliente recebido à lista de clientes
    }

    /**
     * <h2>Método printContas</h2>
     * <p>Imprime no console todas as contas registradas no banco.</p>
     */
    public void printContas() {
        System.out.println(contaList);  // Exibe todas as contas no console
    }

    /**
     * <h2>Método printClientes</h2>
     * <p>Imprime no console todos os clientes registrados no banco.</p>
     */
    public void printClientes() {
        System.out.println(clienteList);  // Exibe todos os clientes no console
    }

    /**
     * <h2>Método consultarCliente</h2>
     * <p>Consulta um cliente no banco pelo CPF e retorna o cliente encontrado.</p>
     * @param cpf O CPF do cliente a ser consultado.
     * @return O cliente correspondente ao CPF fornecido, ou null se não encontrado.
     */
    public Cliente consultarCliente(String cpf) {
        // Percorre todos os clientes da lista procurando pelo CPF
        for (Cliente i : clienteList) {
            if (i.getCpf().equals(cpf)) {  // Verifica se o CPF do cliente é igual ao informado
                System.out.println(i);  // Imprime as informações do cliente encontrado
                return i;  // Retorna o cliente encontrado
            }
        }
        return null;  // Retorna null se o cliente não for encontrado
    }

    /**
     * <h2>Método consultarConta</h2>
     * <p>Consulta uma conta no banco pelo número da conta e retorna a conta encontrada.</p>
     * @param numeroConta O número da conta a ser consultado.
     * @return A conta correspondente ao número fornecido, ou null se não encontrada.
     */
    public Conta consultarConta(String numeroConta) {
        // Percorre todas as contas da lista procurando pelo número da conta
        for (Conta i : contaList) {
            if (i.getNumero().equals(numeroConta)) {  // Verifica se o número da conta é igual ao fornecido
                return i;  // Retorna a conta encontrada
            }
        }
        return null;  // Retorna null se a conta não for encontrada
    }

    /**
     * <h2>Método associar</h2>
     * <p>Associa um cliente a uma conta bancária, caso o cliente ainda não esteja associado a essa conta.</p>
     * @param numeroConta O número da conta a ser associada.
     * @param cpfCliente O CPF do cliente a ser associado à conta.
     */
    public void associar(String numeroConta, String cpfCliente) {
        // Consulta a conta e o cliente com base no número da conta e no CPF
        Conta conta = consultarConta(numeroConta);  // Chama o método consultarConta() para encontrar a conta
        Cliente cliente = consultarCliente(cpfCliente);  // Chama o método consultarCliente() para encontrar o cliente

        // Verifica se o cliente já está associado à conta
        if (conta.cliente.cpf.equals(cpfCliente)) {
            System.out.println("O mesmo cliente não pode ser associado à conta novamente");  // Imprime uma mensagem de erro se o cliente já estiver associado
        }

        // Associa o cliente à conta, se não houver erro
        conta.setCliente(cliente);  // Atribui o cliente à conta utilizando o método setCliente
    }

    /**
     * <h2>Método ListContasCliente</h2>
     * <p>Este método lista todas as contas associadas a um cliente específico, dado o CPF do cliente.</p>
     * @param cpf O CPF do cliente cujas contas serão listadas.
     */
    public void ListContasCliente(String cpf) {
        // Consulta o cliente com o CPF fornecido, utilizando o método consultarCliente.
        Cliente cliente = consultarCliente(cpf);

        // Filtra todas as contas na lista contaList, mantendo apenas aquelas associadas ao cliente.
        List<Conta> contas = contaList.stream()  // Cria um stream de contas da lista contaList.
                .filter(conta -> conta.cliente.equals(cliente))  // Filtra contas onde o cliente associado é igual ao cliente consultado.
                .collect(Collectors.toList());  // Coleta os resultados filtrados em uma nova lista de contas.

        // Exibe no console a lista de contas associadas ao cliente.
        System.out.println(contas);
    }

}
