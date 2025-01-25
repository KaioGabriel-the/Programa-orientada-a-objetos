package entities;  // Declara o pacote onde a classe Conta está localizada

import entities.exceptions.ObjetoNullException;  // Importa a exceção personalizada para objetos nulos
import entities.exceptions.SaldoInsuficienteException;  // Importa a exceção para saldo insuficiente
import entities.exceptions.ValorinconpativelException;  // Importa a exceção para valores inválidos

import java.util.Scanner;  // Importa a classe Scanner para entrada de dados

/**
 * <h2>Classe Conta</h2>
 * <p>Representa uma conta bancária com funcionalidades de depósito, saque e transferência.</p>
 */
public class Conta {
    private int id;  // Identificador único da conta
    private String numero_conta;  // Número da conta
    private float saldo;  // Saldo atual da conta

    /**
     * <h3>Construtor da classe Conta</h3>
     * <p>Inicializa a conta com ID, número e saldo inicial validado.</p>
     *
     * @param id Identificador único da conta
     * @param numero_conta Número da conta
     * @param saldo Saldo inicial
     */
    public Conta(int id, String numero_conta, float saldo) {
        this.id = id;
        this.numero_conta = numero_conta;
        this.saldo = validaValor(saldo);  // Valida o saldo antes de atribuí-lo
    }

    // Métodos getter e setter para os atributos da conta

    public String getNumero_conta() {
        return numero_conta;  // Retorna o número da conta
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;  // Define um novo número para a conta
    }

    public float getSaldo() {
        return saldo;  // Retorna o saldo atual da conta
    }

    public void setSaldo(float saldo) {
        this.saldo = validaValor(saldo);  // Valida o saldo antes de atribuí-lo
    }

    public int getId() {
        return id;  // Retorna o identificador da conta
    }

    public void setId(int id) {
        this.id = id;  // Define um novo identificador para a conta
    }

    /**
     * <h3>Método para depositar valores</h3>
     * <p>Adiciona um valor ao saldo da conta, validando o valor fornecido.</p>
     *
     * @param valor Valor a ser depositado
     */
    public void depositar(float valor) {
        this.saldo += validaValor(valor);  // Valida o valor e adiciona ao saldo
    }

    /**
     * <h3>Método para sacar valores</h3>
     * <p>Subtrai um valor do saldo da conta, verificando se há saldo suficiente.</p>
     *
     * @param valor Valor a ser sacado
     */
    public void sacar(float valor) {
        try {
            if (getSaldo() < validaValor(valor)) {
                throw new SaldoInsuficienteException("Saldo insuficiente");  // Lança exceção se não houver saldo
            }

            this.saldo -= valor;  // Subtrai o valor do saldo
        } catch (Exception erro) {
            erro.printStackTrace();  // Exibe o erro no console
        }
    }

    /**
     * <h3>Método para validar valores</h3>
     * <p>Verifica se o valor fornecido é válido (maior ou igual a 0).</p>
     *
     * @param valor Valor a ser validado
     * @return O valor válido
     */
    public float validaValor(float valor) {
        try {
            if (valor <= 0) {
                throw new ValorinconpativelException();  // Lança exceção se o valor for inválido
            }

            return valor;  // Retorna o valor válido
        } catch (ValorinconpativelException erro) {
            System.out.println("Valor inconpativel");
            Scanner in = new Scanner(System.in);  // Solicita um novo valor ao usuário
            System.out.println("Digite um valor válido: ");
            float novovalor = in.nextFloat();
            return validaValor(novovalor);  // Valida o novo valor
        }
    }

    /**
     * <h3>Método para transferir valores</h3>
     * <p>Transfere um valor da conta atual para outra conta.</p>
     *
     * @param valor Valor a ser transferido
     * @param conta_destino Conta de destino da transferência
     */
    public void transferir(float valor, Conta conta_destino) {
        try {
            if (conta_destino == null) {
                throw new ObjetoNullException("Conta destino não existe");  // Lança exceção se a conta de destino for nula
            }

            if (getSaldo() < validaValor(valor)) {
                throw new SaldoInsuficienteException("Saldo insuficiente");  // Lança exceção se o saldo for insuficiente
            }

            sacar(valor);  // Realiza o saque na conta de origem
            conta_destino.depositar(valor);  // Realiza o depósito na conta de destino

            System.out.println("Transferência realizada com sucesso");  // Mensagem de sucesso
        } catch (Exception erro) {
            erro.printStackTrace();  // Exibe o erro no console
        }
    }

    /**
     * <h3>Método toString</h3>
     * <p>Retorna uma representação em texto da conta.</p>
     *
     * @return Uma string com as informações da conta
     */
    @Override
    public String toString() {
        return "-> Conta" +
                "*Id: " + id + "\n" +
                "*Número da Conta: " + numero_conta + "\n" +
                "*Saldo: " + saldo + "\n";
    }
}
