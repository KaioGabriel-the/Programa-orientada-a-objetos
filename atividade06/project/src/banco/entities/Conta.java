package banco.entities;  // Declara o pacote 'banco.entities', onde a classe Conta está localizada

/**
 * <h2>Classe Conta</h2>
 * <p>Classe que representa uma conta bancária, com métodos para realizar operações como saque, depósito e transferência.</p>
 */
public class Conta {

    /**
     * <h3>ID da Conta</h3>
     * <p>Identificador único da conta bancária.</p>
     */
    int id;

    /**
     * <h3>Número da Conta</h3>
     * <p>O número identificador da conta bancária.</p>
     */
    String numero;

    /**
     * <h3>Saldo da Conta</h3>
     * <p>O saldo disponível na conta bancária.</p>
     */
    float saldo;

    /**
     * <h3>Cliente associado à conta</h3>
     * <p>O cliente que possui a conta bancária.</p>
     */
    Cliente cliente;

    /**
     * <h2>Construtor da classe Conta</h2>
     * <p>Inicializa uma nova conta com os parâmetros fornecidos: id, número da conta, saldo inicial e cliente associado.</p>
     * @param id O identificador único da conta.
     * @param numero O número da conta bancária.
     * @param saldo O saldo inicial da conta.
     * @param cliente O cliente associado à conta.
     */
    public Conta(int id, String numero, float saldo, Cliente cliente) {
        this.id = id;  // Inicializa o ID da conta
        this.numero = numero;  // Inicializa o número da conta
        this.saldo = saldo;  // Inicializa o saldo da conta
        this.cliente = cliente;  // Associa um cliente à conta
    }

    /**
     * <h2>Método getNumero</h2>
     * <p>Retorna o número da conta bancária.</p>
     * @return O número da conta.
     */
    public String getNumero() {
        return numero;  // Retorna o número da conta
    }

    /**
     * <h2>Método setCliente</h2>
     * <p>Associa um novo cliente à conta.</p>
     * @param cliente O cliente a ser associado à conta.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;  // Define um novo cliente para a conta
    }

    /**
     * <h2>Método sacar</h2>
     * <p>Realiza o saque de um valor da conta, caso haja saldo suficiente.</p>
     * @param valor O valor a ser sacado.
     * @return Retorna verdadeiro se o saque for realizado com sucesso, e falso caso contrário.
     */
    public boolean sacar(float valor) {
        if (valor > saldo) {  // Verifica se o valor do saque é maior que o saldo disponível
            System.out.println("O valor do saque é maior que o saldo");  // Exibe mensagem de erro
            return false;  // Retorna falso, indicando que o saque não foi possível
        } else {
            saldo -= valor;  // Subtrai o valor do saldo
            System.out.println("Saque realizado com sucesso");  // Exibe mensagem de sucesso
            return true;  // Retorna verdadeiro, indicando que o saque foi realizado
        }
    }

    /**
     * <h2>Método depositar</h2>
     * <p>Realiza um depósito na conta.</p>
     * @param deposito O valor a ser depositado na conta.
     */
    public void depositar(float deposito) {
        saldo += deposito;  // Adiciona o valor depositado ao saldo
        System.out.println("Dinheiro depositado com sucesso");  // Exibe mensagem de sucesso
    }

    /**
     * <h2>Método transferir</h2>
     * <p>Realiza uma transferência de valor de uma conta para outra.</p>
     * @param contaDestino A conta de destino da transferência.
     * @param valor O valor a ser transferido.
     */
    public void transferir(Conta contaDestino, float valor) {
        if (sacar(valor)) {  // Tenta realizar o saque da conta origem
            contaDestino.depositar(valor);  // Se o saque for bem-sucedido, deposita o valor na conta destino
        } else {
            System.out.println("Não é possível transferir");  // Exibe mensagem de erro se o saque não for possível
        }
    }

    /**
     * <h2>Método toString</h2>
     * <p>Retorna uma representação em string da conta bancária, com informações sobre o ID, número, saldo e cliente associado.</p>
     * @return Uma string contendo as informações da conta.
     */
    @Override
    public String toString() {
        return "Conta:" +
                "id=" + id +  // Exibe o ID da conta
                ", numero='" + numero + '\'' +  // Exibe o número da conta
                ", saldo=" + saldo +  // Exibe o saldo da conta
                ", cliente=" + cliente +  // Exibe o cliente associado à conta
                " ";  // Retorna a string formatada
    }
}
