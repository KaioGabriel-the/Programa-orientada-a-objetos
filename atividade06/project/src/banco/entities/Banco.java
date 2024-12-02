package banco.entities;  // Declara o pacote 'banco.entities', onde a classe Banco está localizada

import java.util.ArrayList;  // Importa a classe ArrayList para utilizar listas dinâmicas
import java.util.List;  // Importa a interface List para criar listas de objetos
import java.util.stream.Collectors;  // Importa a classe Collectors para manipulação de coleções com streams

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
     * <p>Este método é responsável por adicionar uma nova conta à lista de contas do banco.</p>
     * <p>Antes de adicionar a conta, ele verifica se já existe uma conta com o mesmo número ou com o mesmo ID na lista de contas.
     * Caso exista uma conta com o mesmo número ou ID, a nova conta não será adicionada e uma mensagem de erro será exibida.</p>
     *
     * <h3>Passos realizados pelo método:</h3>
     * <ul>
     *   <li>Verifica se já existe uma conta com o mesmo número utilizando o método <code>consultarConta()</code>.</li>
     *   <li>Verifica se já existe uma conta com o mesmo ID utilizando um <code>stream()</code> na lista de contas.</li>
     *   <li>Se não existir uma conta com o mesmo número nem com o mesmo ID, a nova conta é adicionada à lista <code>contaList</code>.</li>
     *   <li>Se a conta for adicionada com sucesso, uma mensagem de confirmação é impressa no console.</li>
     * </ul>
     *
     * <h3>Parâmetros:</h3>
     * <ul>
     *   <li><code>conta</code>: A conta a ser adicionada à lista de contas do banco.</li>
     * </ul>
     */
    public void inserirConta(Conta conta) {
        Conta novaConta = conta;

        // Verifica se já existe uma conta com o mesmo número
        Conta existeNumero = consultarConta(novaConta.numero);

        // Verifica se já existe uma conta com o mesmo ID usando stream para filtrar
        boolean existeId = contaList.stream()
                .anyMatch(conta1 -> conta1.id == novaConta.id);  // Retorna true se o ID já existir na lista

        // Se não existir uma conta com o mesmo número nem com o mesmo ID, adiciona a nova conta
        if (existeNumero == null && !existeId) {
            contaList.add(novaConta);  // Adiciona a nova conta à lista
            System.out.println("Conta adicionada com sucesso.");
        } else {
            System.out.println("Erro: Já existe uma conta com esse número ou ID.");
        }
    }


    /**
     * <h2>Método inserirCliente</h2>
     * <p>Adiciona um novo cliente à lista de clientes do banco.</p>
     *
     * @param cliente O cliente a ser adicionado à lista de clientes.
     */
    public void inserirCliente(Cliente cliente) {
        Cliente novoCliente = cliente;
        Cliente existeCpf = consultarCliente(novoCliente.cpf);  // Consulta se já existe um cliente com o CPF fornecido
        Cliente existeId = consultarClienteId(novoCliente.id);  // Consulta se já existe um cliente com o ID fornecido
        if (existeId == null && existeCpf == null) {  // Verifica se o cliente com o CPF ou ID não existe
            // Adiciona o cliente à lista de clientes do banco
            clienteList.add(novoCliente);
        }
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
     *
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
     *
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
     *
     * @param numeroConta O número da conta a ser associada.
     * @param cpfCliente  O CPF do cliente a ser associado à conta.
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
     *
     * @param cpf O CPF do cliente cujas contas serão listadas.
     * @return Uma lista de contas associadas ao cliente com o CPF fornecido.
     */
    public List<Conta> listContasCliente(String cpf) {
        // Consulta o cliente com o CPF fornecido, utilizando o método consultarCliente.
        Cliente cliente = consultarCliente(cpf);

        // Filtra todas as contas na lista contaList, mantendo apenas aquelas associadas ao cliente.
        List<Conta> contas = contaList.stream()  // Cria um stream de contas da lista contaList.
                .filter(conta -> conta.getCliente().equals(cliente))  // Filtra contas onde o cliente associado é igual ao cliente consultado.
                .collect(Collectors.toList());  // Coleta os resultados filtrados em uma nova lista de contas.

        // Exibe no console a lista de contas associadas ao cliente.
        System.out.println(contas);

        // Retorna a lista de contas
        return contas;
    }

    /**
     * <h2>Método totalizarSaldoCliente</h2>
     * <p>Este método calcula o saldo total de todas as contas associadas a um cliente, dado o CPF do cliente.</p>
     *
     * @param cpf O CPF do cliente cujos saldos das contas serão somados.
     * @return O saldo total das contas do cliente, representado por um número do tipo float.
     */
    public float totalizarSaldoCliente(String cpf) {
        // Consulta todas as contas associadas ao cliente com o CPF fornecido,
        // utilizando o método listContasCliente(cpf).
        List<Conta> contas = listContasCliente(cpf);

        // Utiliza o método reduce para somar o saldo de todas as contas.
        // O método stream() cria um fluxo de contas, e map() acessa o saldo de cada conta.
        // O reduce() acumula os saldos, somando-os de forma sequencial.
        float saldoTotal = contas.stream()
                .map(Conta::getSaldo) // Acessa o saldo de cada conta na lista.
                .reduce(0f, (saldo, maisSaldo) -> saldo + maisSaldo); // Soma todos os saldos, começando com 0f.

        // Retorna o saldo total das contas do cliente.
        return saldoTotal;
    }

    /**
     * <h2>Método consultarClienteId</h2>
     * <p>Consulta um cliente no banco pelo ID e retorna o cliente encontrado.</p>
     *
     * @param id O ID do cliente a ser consultado.
     * @return O cliente correspondente ao ID fornecido, ou null se não encontrado.
     */
    public Cliente consultarClienteId(int id) {
        // Percorre todos os clientes da lista procurando pelo ID
        for (Cliente i : clienteList) {
            if (i.getId() == id) {  // Verifica se o ID do cliente é igual ao informado
                System.out.println(i);  // Imprime as informações do cliente encontrado
                return i;  // Retorna o cliente encontrado
            }
        }
        return null;  // Retorna null se o cliente não for encontrado
    }
}