package app;

import entities.Banco;
import entities.Cliente;
import entities.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        String menu = "----- MENU ----- \n"
                    +"Conta: \n"
                    + "1- Abrir conta\n"
                    + "2- Listar conta\n"
                    + "3- Depositar\n"
                    + "4- Sacar\n"
                    + "5- Transferir\n"
                    + "6- Listar contas\n"
                    + "7- Listar contas de cliente\n"
                    + "8- Consultar saldo\n" +
                    "9- Buscar contas sem cliente\n" +
                    "10- Pagamentos multiplos" +
                    "11- Excluir conta"
                    + "Cliente: \n"
                    + "12- Cadastrar cliente\n"
                    + "13- Listar cliente\n" +
                    "14- Listar clientes\n" +
                    "15- alterar dados de cliente\n" +
                    "16- Lincar conta ao cliente\n" +
                    "17- Excluir cliente\n" +
                    "0- Sair do programa"
                    ;
        Scanner in = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println(menu);
            System.out.println("Digite a opcao: ");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    criarConta(banco);
                    break;
                case 2:
                    listarConta(banco);
                    break;
                case 3:
                    depositar(banco);
                    break;
                case 4:
                    sacar(banco);
                    break;
                case 5:
                    transferir(banco);
                    break;
                case 6:
                    listarContas(banco);
                    break;
                case 7:
                    listarContasCliente(banco);
                    break;
                case 8:
                    listarConta(banco);
                    break;
                case 9:
                    buscarContasSemCliente(banco);
                    break;
                case 10:
                    pagamentosMultiplos(banco);
                    break;
                case 11:
                    excluirConta(banco);
                    break;
                case 12:
                    cadastrarCliente(banco);
                    break;
                case 13:
                    listarCliente(banco);
                    break;
                case 14:
                    listarClientes(banco);
                    break;
                case 15:
                    alterarDados(banco);
                    break;
                case 16:
                    lincarContaCliente(banco);
                    break;
                case 17:
                    excluirCliente(banco);
                    break;
                default:
                    opcao = 0;
                    System.out.println("Opcao invalida!");
            }
        }while (opcao != 0);
    }

    public static void clearScreen() {
        try {
            // Para Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para sistemas Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void criarConta(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o numero da conta: ");
        int numero = in.nextInt();

        System.out.println("Digite o saldo da conta: ");
        float saldo = in.nextFloat();

        Conta conta = new Conta(numero, saldo);
        banco.cadastrarConta(conta);
        System.out.println("Conta Cadastrado com sucesso!\n");
        System.out.println(conta.toString());
    }

    public static void listarConta(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o numero da conta: ");
        int numero = in.nextInt();

        Conta conta = banco.buscarConta(numero);
        if(conta != null) {
            System.out.println(conta.toString());
        }

    }

    public static void depositar(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o numero da conta que deseja depositar: ");
        int numero = in.nextInt();

        System.out.println("Digite o valor que deseja depositar: ");
        float valor = in.nextFloat();

        Conta conta = banco.buscarConta(numero);

        if(conta != null) {
            banco.depositar(conta, valor);
            System.out.println(conta.toString());
            System.out.println("Deposito realizado com sucesso! \n");
        }

    }
    public static void sacar(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o numero da conta: ");
        int numero = in.nextInt();

        System.out.println("Digite o valor que deseja sacar: ");
        float valor = in.nextFloat();
        Conta conta = banco.buscarConta(numero);

        if(conta != null) {
            banco.sacar(conta, valor);
        }
    }

    public static void transferir(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o numero da sua conta: ");
        int numeroConta = in.nextInt();

        System.out.println("Digite o numero da conta que deseja transferir: ");
        int numeroDestino = in.nextInt();

        System.out.println("Digite o valor que deseja transferir: ");
        float valorDestino = in.nextFloat();

        Conta conta = banco.buscarConta(numeroConta);
        Conta contaDestino = banco.buscarConta(numeroDestino);

        if((conta != null) && (contaDestino != null)) {
            banco.transferir(conta, contaDestino, valorDestino);
            System.out.println(contaDestino.toString());
            System.out.println("Transferencia realizada com sucesso! \n");
        }
    }

    public static void listarContas(Banco banco) {
        for (Conta conta : banco.getContas()) {
            System.out.println(conta.toString());
        }
    }

    public static void listarContasCliente(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite do cpf do cliente: ");
        String cpf = in.next();

        Cliente cliente = banco.buscarCliente(cpf);
        List<Conta> contas = banco.buscarContasClientes(cliente);

        if(cliente != null) {
            for (Conta conta : contas) {
                System.out.println(conta.toString());
            }
        }
    }

    public static void buscarContasSemCliente(Banco banco) {
        Scanner in = new Scanner(System.in);
        List<Conta> contas = banco.buscarContasSemCliente();
        System.out.println("Digite o cpf do cliente que deseja atribuir todas as contas: ");
        String cpf = in.next();
        Cliente cliente = banco.buscarCliente(cpf);

        if((contas != null) && (cliente != null)) {
            banco.definirTitularidade(cliente, contas);
            System.out.println("Contas atribuidas com sucesso! \n");
        }
    }

    public static void pagamentosMultiplos(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite a quntidade de contas que deseja transferir: ");
        int numeroContas = in.nextInt();

        System.out.println("Digite o numero da conta que deseja retirar o dinheiro: ");
        int numeroRetirada = in.nextInt();
        Conta contaRetirada = banco.buscarConta(numeroRetirada);

        if(contaRetirada != null) {
            for (int i = 0; i < numeroContas; i++) {
                System.out.println("Digite o numero da conta " + (i) + ": ");
                int numeroConta = in.nextInt();
                System.out.println("Digite o valor que deseja transferir: ");
                float valor = in.nextFloat();
                Conta conta = banco.buscarConta(numeroConta);
                if (conta != null) {
                    banco.transferir(contaRetirada,conta, valor);
                    System.out.println(conta.toString());
                }
            }
        }
    }

    public static void excluirConta(Banco banco) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        int numeroConta = in.nextInt();
        if(banco.buscarConta(numeroConta) != null) {
            banco.excluirConta(numeroConta);
            System.out.println("Conta excluida com sucesso! \n");
        }
    }

    public static void cadastrarCliente(Banco banco) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = in.next();
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = in.next();
        System.out.println("Digite o telefone do cliente: ");
        String telefoneCliente = in.next();
        System.out.println("Digite a data de nascimento do cliente(dd/MM/yyyy): ");
        String dataNascimento = in.next();
        Cliente cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente, dataNascimento);
        banco.cadastrarCliente(cliente);
    }

    public static void listarCliente(Banco banco) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = in.next();
        Cliente cliente = banco.buscarCliente(cpfCliente);
        if(cliente != null) {
            System.out.println(cliente.toString());
        }
    }

    public static void listarClientes(Banco banco) {
        List<Cliente> clientes = banco.getClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public static void alterarDados(Banco banco) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = in.next();
        Cliente cliente = banco.buscarCliente(cpfCliente);
        if(cliente != null) {
            banco.alterarCliente(cliente);
        }
    }

    public static void lincarContaCliente(Banco banco) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = in.next();
        Cliente cliente = banco.buscarCliente(cpfCliente);

        System.out.println("Digite o numero da conta: ");
        int numeroConta = in.nextInt();

        Conta conta = banco.buscarConta(numeroConta);

        if((cliente != null) && (conta != null)) {
            banco.lincarContaCliente(cpfCliente,numeroConta);
            System.out.println("Conta alterada com sucesso! \n");
            System.out.println(conta.toString());
        }
    }

    public static void excluirCliente(Banco banco) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = in.next();
        Cliente cliente = banco.buscarCliente(cpfCliente);
        if(cliente != null) {
            banco.excluirCliente(cpfCliente);
            System.out.println("Cliente excluida com sucesso! \n");
        }
    }

}
