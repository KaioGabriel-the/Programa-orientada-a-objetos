package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um banco que gerencia uma lista de contas.
 */
public class Banco {
    // Lista que armazena as contas do banco.
    private List<Conta> contas;

    /**
     * Construtor do banco. Inicializa a lista de contas.
     */
    public Banco() {
        // Inicializa a lista de contas como uma nova ArrayList.
        this.contas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova conta à lista de contas do banco.
     *
     * @param novaConta A conta a ser inserida.
     */
    public void inserir(Conta novaConta) {
        // Adiciona a conta à lista de contas.
        contas.add(novaConta);
    }

    /**
     * Consulta uma conta com base no número da conta.
     *
     * @param numero O número da conta a ser consultada.
     * @return A conta encontrada ou null se a conta não existir.
     */
    public Conta consultar(String numero) {
        // Variável para armazenar a conta procurada, inicializada como null.
        Conta contaProcurada = null;

        // Percorre a lista de contas para encontrar a conta com o número correspondente.
        for (Conta conta : contas) {
            // Compara o número da conta atual com o número passado como parâmetro.
            if (conta.getNumero().equals(numero)) {
                // Se encontrar a conta, armazena e sai do loop.
                contaProcurada = conta;
                break;
            }
        }
        // Retorna a conta encontrada ou null se não encontrar.
        return contaProcurada;
    }

    /**
     * Consulta o índice de uma conta na lista com base no número da conta.
     *
     * @param numero O número da conta a ser consultada.
     * @return O índice da conta na lista ou -1 se a conta não existir.
     */
    public int consultarPorIndice(String numero) {
        // Variável para armazenar o índice da conta procurada, inicializada como -1 (não encontrado).
        int indiceProcurado = -1;

        // Percorre a lista de contas para encontrar o índice da conta com o número correspondente.
        for (int i = 0; i < contas.size(); i++) {
            // Compara o número da conta na posição i com o número passado como parâmetro.
            if (contas.get(i).getNumero().equals(numero)) {
                // Se encontrar a conta, armazena o índice e sai do loop.
                indiceProcurado = i;
                break;
            }
        }
        // Retorna o índice encontrado ou -1 se não encontrar.
        return indiceProcurado;
    }

    /**
     * Exclui uma conta da lista com base no número da conta.
     *
     * @param numero O número da conta a ser excluída.
     */
    public void excluir(String numero) {
        // Obtém o índice da conta a ser excluída.
        int indiceProcurado = consultarPorIndice(numero);

        // Verifica se a conta foi encontrada (índice diferente de -1).
        if (indiceProcurado != -1) {
            // Move os elementos da lista para a esquerda, sobrescrevendo a conta a ser removida.
            for (int i = indiceProcurado; i < contas.size() - 1; i++) {
                // Move o próximo elemento para a posição atual.
                contas.set(i, contas.get(i + 1));
            }
            // Remove o último elemento da lista, que agora é duplicado após a movimentação.
            contas.remove(contas.size() - 1);
        }
    }

    /**
     * Realiza um depósito em uma conta específica.
     *
     * @param numero O número da conta em que o depósito será feito.
     * @param valor O valor a ser depositado.
     */
    public void depositar(String numero, float valor) {
        // Consulta a conta pelo número fornecido.
        Conta contaProcurada = consultar(numero);

        // Verifica se a conta foi encontrada e realiza o depósito.
        if (contaProcurada != null) {
            contaProcurada.depositar(valor);
        } else {
            // Se a conta não for encontrada, imprime uma mensagem de erro.
            System.out.println("Conta não encontrada");
        }
    }

    /**
     * Realiza uma transferência de valor de uma conta para outra.
     *
     * @param numeroRecebe O número da conta que receberá o valor.
     * @param numeroManda O número da conta de onde o valor será retirado.
     * @param valor O valor a ser transferido.
     */
    public void tranferir(String numeroRecebe, String numeroManda, float valor) {
        // Consulta as contas de origem e destino pelo número.
        Conta recebe = consultar(numeroRecebe);
        Conta manda = consultar(numeroManda);

        // Verifica se ambas as contas foram encontradas.
        if (recebe != null && manda != null) {
            // Realiza o saque da conta de origem e o depósito na conta de destino.
            manda.sacar(valor);
            recebe.depositar(valor);
        }
    }

    /**
     * Altera uma conta na lista com base no número da conta.
     *
     * @param conta A conta a ser alterada.
     */
    public void aleterar(Conta conta) {
        // Consulta a conta pelo número da conta passada como parâmetro.
        Conta contaProcurada = consultar(conta.getNumero());

        // Verifica se a conta foi encontrada.
        if (contaProcurada != null) {
            // Obtém o índice da conta na lista.
            int index = consultarPorIndice(contaProcurada.getNumero());

            // Verifica se o índice é válido.
            if (index >= 0 && index < contas.size()) {
                // Substitui a conta existente pelo objeto de conta passado como parâmetro.
                contas.set(index, conta);
            }
        }
    }

    /**
     * Realiza um depósito em todas as contas da lista, exceto na última.
     *
     * @param contas A lista de contas em que o depósito será feito.
     * @param valor O valor a ser depositado.
     */
    public void transferirArray(List<Conta> contas, float valor) {
        // Verifica se o valor é negativo (o depósito só deve ser feito com valor positivo).
        if (valor < 0.0) {
            // Percorre todas as contas, exceto a última.
            for (int i = 0; i < contas.size() - 1; i++) {
                // Realiza o depósito em cada conta.
                contas.get(i).depositar(valor);
            }
        }
    }

    /**
     * Retorna a quantidade de contas no banco.
     *
     * @return O número de contas no banco.
     */
    public int qunatidadeContasBanco() {
        // Retorna o tamanho da lista de contas.
        return contas.size();
    }

    /**
     * Retorna o total de dinheiro acumulado em todas as contas do banco.
     *
     * @return O total de dinheiro.
     */
    public float quantidadeDinheiro() {
        // Variável para armazenar o total de dinheiro.
        float totalDinheiro = 0;

        // Percorre a lista de contas e soma os saldos de cada conta.
        for (int i = 0; i < contas.size(); i++) {
            totalDinheiro += contas.get(i).consultarSaldo();
        }

        // Retorna o total de dinheiro.
        return totalDinheiro;
    }

    /**
     * Retorna a média dos saldos das contas no banco.
     *
     * @return A média dos saldos.
     */
    public float mediaSaldo() {
        // Calcula a média dividindo o total de dinheiro pelo número de contas.
        float saldomedio = quantidadeDinheiro() / qunatidadeContasBanco();
        // Retorna a média dos saldos.
        return saldomedio;
    }
}
