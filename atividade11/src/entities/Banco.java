package entities;  // Declara o pacote onde a classe Banco está localizada

import java.util.ArrayList;  // Importa a classe ArrayList para usar listas dinâmicas
import java.util.List;  // Importa a interface List para criar listas de objetos

/**
 * <h2>Classe Banco</h2>
 * <p>Classe responsável por gerenciar operações bancárias, como adicionar contas, realizar transações e listar contas cadastradas.</p>
 */
public class Banco {

    /**
     * <h3>Lista de contas</h3>
     * <p>Armazena todas as contas cadastradas no banco.</p>
     */
    private List<Conta> contas;

    /**
     * <h2>Construtor da classe Banco</h2>
     * <p>Inicializa a lista de contas do banco como uma lista vazia.</p>
     */
    public Banco() {
        this.contas = new ArrayList<>();  // Cria uma nova lista para armazenar contas
    }

    /**
     * <h2>Método para adicionar uma conta</h2>
     * <p>Cria uma nova conta com os dados fornecidos e a adiciona à lista de contas do banco.</p>
     *
     * @param id Identificador único da conta
     * @param numero_saldo Número associado à conta
     * @param saldo Saldo inicial da conta
     */
    public void adicionarConta(int id, String numero_saldo, float saldo) {
        Conta novaconta = new Conta(id, numero_saldo, saldo);  // Cria uma nova instância de Conta
        contas.add(novaconta);  // Adiciona a conta à lista de contas
        System.out.println("Conta cadastrada com sucesso");  // Confirmação do cadastro
    }

    /**
     * <h2>Método para procurar uma conta</h2>
     * <p>Busca na lista de contas uma conta com o número fornecido.</p>
     *
     * @param numero_conta Número da conta a ser buscada
     * @return A conta correspondente ou null, se não for encontrada
     */
    public Conta procurarConta(String numero_conta) {
        // Usa Stream para buscar a conta pelo número
        return contas.stream()
                .filter(conta -> conta.getNumero_conta().equals(numero_conta))  // Corrige a comparação usando equals
                .findFirst()  // Retorna o primeiro elemento que corresponde ao filtro
                .orElse(null);  // Retorna null se nenhuma conta for encontrada
    }

    /**
     * <h2>Método para depositar</h2>
     * <p>Adiciona o valor especificado ao saldo da conta fornecida.</p>
     *
     * @param conta A conta onde o valor será depositado
     * @param valor O valor a ser depositado
     */
    public void depositar(Conta conta, float valor) {
        conta.depositar(valor);  // Chama o método de depósito na conta
        System.out.println("Depósito concluído com sucesso...");  // Confirmação do depósito
    }

    /**
     * <h2>Método para sacar</h2>
     * <p>Subtrai o valor especificado do saldo da conta fornecida.</p>
     *
     * @param conta A conta de onde o valor será retirado
     * @param valor O valor a ser sacado
     */
    public void sacar(Conta conta, float valor) {
        conta.sacar(valor);  // Chama o método de saque na conta
        System.out.println("Saque efetuado com sucesso");  // Confirmação do saque
    }

    /**
     * <h2>Método para transferir</h2>
     * <p>Transfere o valor especificado de uma conta para outra.</p>
     *
     * @param conta A conta de origem
     * @param conta_destino A conta de destino
     * @param valor O valor a ser transferido
     */
    public void transferir(Conta conta, Conta conta_destino, float valor) {
        conta.transferir(valor, conta_destino);  // Realiza a transferência entre as contas
        System.out.println("Transferência realizada com sucesso!!!");  // Confirmação da transferência
    }

    /**
     * <h2>Método para imprimir contas</h2>
     * <p>Exibe no console todas as contas cadastradas no banco.</p>
     */
    public void imprirContas() {
        for (Conta conta : this.contas) {  // Itera sobre a lista de contas
            System.out.println(conta);  // Imprime as informações de cada conta
        }
    }
}
