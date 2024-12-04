package entities;  // Declara o pacote 'entities', onde a classe Conta está localizada

/**
 * <h2>Classe Conta</h2>
 * <p>Classe que representa uma conta bancária, com métodos para realizar operações como saque, depósito e transferência.</p>
 */
public class Conta {

    /**
     * <h3>Número da Conta</h3>
     * <p>Identificador único da conta bancária.</p>
     */
    private String numero;  // Número de identificação da conta

    /**
     * <h3>Saldo da Conta</h3>
     * <p>O saldo disponível na conta bancária.</p>
     */
    private float saldo;  // Saldo da conta

    /**
     * <h3>Construtor da Classe Conta</h3>
     * <p>Cria uma nova instância da classe Conta com o número da conta e saldo inicial fornecidos.</p>
     * @param numero Número de identificação da conta
     * @param saldo Saldo inicial da conta
     */
    public Conta(String numero, float saldo) {
        this.numero = numero;  // Inicializa o número da conta com o valor passado
        this.saldo = saldo;  // Inicializa o saldo da conta com o valor passado
    }

    /**
     * <h3>Método para sacar um valor</h3>
     * <p>Permite que um valor seja retirado do saldo da conta, se for positivo e o saldo for suficiente.</p>
     * @param valor O valor a ser sacado
     * @return true se o saque for bem-sucedido, false se não for possível
     */
    public boolean sacar(float valor) {
        // Verifica se o valor é positivo e se o saldo é suficiente para realizar o saque
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;  // Subtrai o valor do saldo da conta
            return true;  // Retorna true indicando que o saque foi bem-sucedido
        } else {
            // Mensagem de erro se o saque não for possível
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;  // Retorna false indicando que o saque falhou
        }
    }

    /**
     * <h3>Método para depositar um valor</h3>
     * <p>Permite que um valor seja adicionado ao saldo da conta, se for positivo.</p>
     * @param valor O valor a ser depositado
     * @return true se o depósito for bem-sucedido, false se não for possível
     */
    public boolean depositar(float valor) {
        // Verifica se o valor é positivo antes de adicionar ao saldo
        if (valor > 0) {
            saldo += valor;  // Adiciona o valor ao saldo da conta
            return true;  // Retorna true indicando que o depósito foi bem-sucedido
        } else {
            // Mensagem de erro se o depósito não for possível
            System.out.println("Valor de depósito inválido.");
            return false;  // Retorna false indicando que o depósito falhou
        }
    }

    /**
     * <h3>Método para consultar o saldo</h3>
     * <p>Retorna o saldo atual da conta.</p>
     * @return O saldo da conta
     */
    public float consultarSaldo() {
        return saldo;  // Retorna o saldo atual da conta
    }

    /**
     * <h3>Método para transferir um valor para outra conta</h3>
     * <p>Permite que um valor seja transferido de uma conta para outra, se for positivo e o saldo for suficiente.</p>
     * @param contaDestino A conta para a qual o valor será transferido
     * @param valor O valor a ser transferido
     * @return true se a transferência for bem-sucedida, false se não for possível
     */
    public boolean transferir(Conta contaDestino, float valor) {
        // Verifica se o valor é positivo e se o saldo da conta atual é suficiente
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);  // Chama o método sacar para remover o valor da conta atual
            contaDestino.depositar(valor);  // Chama o método depositar para adicionar o valor à conta destino
            return true;  // Retorna true indicando que a transferência foi bem-sucedida
        } else {
            // Mensagem de erro se a transferência não for possível
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
            return false;  // Retorna false indicando que a transferência falhou
        }
    }

    /**
     * <h3>Método getter para o número da conta</h3>
     * <p>Retorna o número da conta.</p>
     * @return O número da conta
     */
    public String getNumero() {
        return numero;  // Retorna o número da conta
    }

    /**
     * <h3>Método toString</h3>
     * <p>Retorna uma representação em string do estado atual da conta.</p>
     * @return Uma string representando a conta
     */
    @Override
    public String toString() {
        // Formata a saída para exibir número e saldo da conta
        return "Conta \n" +
                "numero =" + numero + "\n saldo=" + saldo + "\n";
    }
}
