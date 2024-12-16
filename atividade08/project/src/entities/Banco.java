package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarConta(Conta conta) {
        contas.add(conta);
    }

    public void alterarCliente(Cliente cliente) {
        String menu = "Alterar cliente: \n" +
                "1 - Telefone;\n"
                + "2 - CPF.\n"
                + "Digite a opcao desejada:\n";
        ;
        System.out.println(menu);
        Scanner in = new Scanner(System.in);
        int opcao = in.nextInt();

        switch (opcao) {
            case 1:
                alterarCpfCliente(cliente);
                break;
            case 2:
                alterarTelCliente(cliente);
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
    }

    private void alterarCpfCliente(Cliente cliente) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o novo CPF do cliente:");
        String cpf = in.next();
        cliente.setCpf(cpf);
        in.close();
    }

    private void alterarTelCliente(Cliente cliente) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o novo telefone:");
        String telefone = in.next();
        cliente.setTelefone(telefone);
        in.close();
    }

    public void sacar(Conta conta, Float valor){
        if(valor <= conta.getSaldo()){
            conta.sacar(valor);
            System.out.println(conta.toString());
            System.out.println("saque realizado com sucesso");
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void transferir(Conta conta, Conta destino, float valor) {
        if (conta.sacar(valor) && destino.depositar(valor)) {
            conta.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferido com sucesso!");
        }
        System.out.println("Saldo insuficiente");
    }

    public void depositar(Conta destino, float valor) {
        destino.depositar(valor);
        System.out.println("Depositado com sucesso!");
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }

        return null;
    }

    public void lincarContaCliente(String cpf, int numero) {
        Cliente cliente = buscarCliente(cpf);
        Conta conta = buscarConta(numero);
        conta.setCliente(cliente);
        cliente.setContas(conta);
    }

    public List<Conta> buscarContasClientes(Cliente cliente) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getCliente().equals(cliente)) {
                contasCliente.add(conta);
            }
        }
        return contasCliente;
    }

    public void excluirCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        List<Conta> contasCliente = buscarContasClientes(cliente);

        if (cliente != null) {
            contasDestinoExcluir(contasCliente);
            contas.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void contasDestinoExcluir(List<Conta> contasCliente) {
        Scanner in = new Scanner(System.in);
        System.out.println("O Cliente possui " + contasCliente + "contas");
        String menu = "Menu: \n"
                + "1 - Excluir toda(s) as conta(s), sem resgatar saldo;\n"
                + "2 - Resgatar saldo das conta(s).\n" +
                "Digite a opcao desejada:\n";
        System.out.println(menu);
        int opcao = in.nextInt();

        switch (opcao) {
            case 1:
                excluirContas(contasCliente);
                break;
            case 2:
                tranferirDinheiroDasContas(contasCliente);
                break;
            default:
                System.out.println("Opcao invalida");
        }

    }

    private void excluirContas(List<Conta> contasCliente) {
        for (Conta conta : contasCliente) {
            if (contas.equals(conta)) {
                contas.remove(conta);
            }
        }
    }

    private void tranferirDinheiroDasContas(List<Conta> contasCliente) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero da conta que deseja tranferir: ");
        int numero = in.nextInt();
        Conta contaDestino = buscarConta(numero);
        if (contaDestino != null) {
            for (Conta conta : contasCliente) {
                transferir(conta,contaDestino,conta.saldo);
                contas.remove(conta);
            }
        }
    }

    public void excluirConta(int numero) {
        Conta conta = buscarConta(numero);
        List<Conta> contaExcluida = new ArrayList<>();
        contaExcluida.add(conta);
        if (conta != null) {
            tranferirDinheiroDasContas(contaExcluida);
            contas.remove(conta);
            System.out.println("Conta removido com sucesso!");
        }
    }

    public List<Conta> buscarContasSemCliente() {
        List<Conta> contasSemCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getCliente().equals(null)){
                contasSemCliente.add(conta);
            }
        }
        return contasSemCliente;
    }

    public void definirTitularidade(Cliente cliente, List<Conta> contas) {
        List<Conta> contasNull = contas;
        for (Conta conta : contasNull) {
            conta.setCliente(cliente);
        }
    }

    public void depositarMulContas(Conta conta, List<Conta> contasDestinos, float valor) {
        float depositos = conta.getSaldo() / contasDestinos.size();

        if(valor <= depositos) {
            for (Conta contaDestino : contasDestinos) {
                conta.sacar(valor);
                contaDestino.depositar(valor);
            }
        }
    }

    public List<Cliente> getClientes () {
        return clientes;
    }

    public List<Conta> getContas () {
        return contas;
    }
}