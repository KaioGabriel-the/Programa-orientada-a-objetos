package entities.banco;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;
    private int idClienteAtual;
    private int idContaAtual;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.idClienteAtual = 0;
        this.idContaAtual = 0;
    }

    public void inserirConta(Conta conta) {
        conta.set_id(this.idContaAtual++);
        this.contas.add(conta);
    }

    public Conta consultarConta(String numero) {
        for (Conta conta : this.contas) {
            if (conta.get_numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    private int consultarContaPorIndice(String numero) {
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).get_numero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public void excluir(String numero) {
        int indiceProcurado = this.consultarContaPorIndice(numero);
        if (indiceProcurado != -1) {
            this.contas.remove(indiceProcurado);
        }
    }

    public void alterar(Conta conta) {
        Conta contaProcurada = this.consultarConta(conta.get_numero());
        if (contaProcurada != null) {
            int indice = this.consultarContaPorIndice(conta.get_numero());
            this.contas.set(indice, conta);
        }
    }

    public void inserirCliente(Cliente cliente) {
        cliente.set_id(this.idClienteAtual++);
        this.clientes.add(cliente);
    }

    public Cliente consultarCliente(String cpf) {
        for (Cliente cliente : this.clientes) {
            if (cliente.get_cpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void sacar(String numero, double valor) {
        Conta contaProcurada = this.consultarConta(numero);
        if (contaProcurada != null) {
            contaProcurada.sacar(valor);
        }
    }

    public void depositar(String numero, double valor) {
        Conta contaProcurada = this.consultarConta(numero);
        if (contaProcurada != null) {
            contaProcurada.depositar(valor);
        }
    }

    public void transferir(String numeroOrigem, String numeroDestino, double valor) {
        Conta contaOrigem = this.consultarConta(numeroOrigem);
        Conta contaDestino = this.consultarConta(numeroDestino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        }
    }

    public void associarContaCliente(String numeroConta, String cpfCliente) {
        Conta contaProcurada = this.consultarConta(numeroConta);
        Cliente clienteProcurado = this.consultarCliente(cpfCliente);
        if (contaProcurada != null && clienteProcurado != null) {
            contaProcurada.set_cliente(clienteProcurado);
            clienteProcurado.adicionaConta(contaProcurada);
        }
    }

    public boolean jaExisteContaParaCliente(Cliente cliente, Conta conta) {
        if (conta.get_cliente() != null && conta.get_cliente().get_cpf().equals(cliente.get_cpf())) {
            return true;
        }
        for (Conta contaAssociada : cliente.copiaContas()) {
            if (contaAssociada.get_numero().equals(conta.get_numero())) {
                return true;
            }
        }
        return false;
    }

    public List<Conta> listarContasCliente(String cpf) {
        Cliente clienteProcurado = this.consultarCliente(cpf);
        if (clienteProcurado != null) {
            return clienteProcurado.copiaContas();
        }
        return new ArrayList<>();
    }

    public void renderJuros(String numero) {
        Conta contaProcurada = this.consultarConta(numero);
        if (contaProcurada instanceof Poupanca) {
            ((Poupanca) contaProcurada).renderJuros();
        }
    }

    public double totalizarSaldoCliente(String cpf) {
        Cliente clienteProcurado = this.consultarCliente(cpf);
        double total = 0;
        if (clienteProcurado != null) {
            for (Conta conta : clienteProcurado.copiaContas()) {
                total += conta.get_saldo();
            }
        }
        return total;
    }

    public int obterQuantidadeDeContas() {
        return this.contas.size();
    }

    public double obterTotalDinheiroDepositado() {
        double total = 0;
        for (Conta conta : this.contas) {
            total += conta.get_saldo();
        }
        return total;
    }

    public double calcularMediaSaldoContas() {
        if (this.contas.isEmpty()) {
            return 0;
        }
        return this.obterTotalDinheiroDepositado() / this.obterQuantidadeDeContas();
    }

    public boolean ehPoupanca(Conta conta) {
        return conta instanceof Poupanca;
    }
}
