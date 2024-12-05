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

    public void depositar(String numero, float valor){
        Conta contaProcurada = consultar(numero);

        if(contaProcurada != null) contaProcurada.depositar(valor);
        else System.out.println("Conta não encontrada");
    }

    public void tranferir(String numeroRecebe, String numeroManda, float valor){
        Conta recebe = consultar(numeroRecebe);
        Conta manda = consultar(numeroManda);

        if((recebe != null && manda != null)){
            manda.sacar(valor);
            recebe.depositar(valor);
        }

    }

    public void aleterar(Conta conta){
        Conta contaProcurada = consultar(conta.getNumero());

        if(contaProcurada != null){
            int index = consultarPorIndice(contaProcurada.getNumero());

            if(index >= 0 && index < contas.size())
                contas.set(index,conta);
        }
    }

    public void transferirArray(List<Conta> contas, float valor){
        if(valor < 0.0){
            for(int i = 0; i < contas.size()-1; i++){
                contas.get(i).depositar(valor);
            }
        }
    }

    public int qunatidadeContasBanco(){
        return contas.size();
    }
    public int quantidadeContasUsuario(List<Conta> contas){
        return  contas.size();
    }
}
