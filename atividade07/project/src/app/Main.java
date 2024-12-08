package app;  // Declara o pacote 'app', onde a classe Main está localizada

import entities.Banco;  // Importa a classe Banco, que representa o banco e suas operações
import entities.Cliente;  // Importa a classe Cliente, que representa um cliente bancário
import entities.Conta;  // Importa a classe Conta, que representa uma conta bancária

import java.util.Scanner;  // Importa a classe Scanner para ler entradas do usuário

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();  // Cria uma instância do banco

        // Definição do menu de opções que o usuário pode escolher
        String menu = "----- MENU ----- \n" +
                "Contas: \n" +
                "1- Inserir;\n" +
                "2- Consultar;\n" +
                "3- Sacar;\n" +
                "4- Depositar;\n" +
                "5- Excluir;\n" +
                "6 - Transferir;\n" +
                "7 - Totalizações;\n" +
                "Clientes: \n" +
                "8 - Inserir;\n" +
                "9 - Consultar;\n" +
                "10 - Associar;\n";

        // Cria o objeto Scanner para capturar entradas do usuário
        Scanner in = new Scanner(System.in);

        // Lê a primeira opção do menu
        int opcao = in.nextInt();

        // Loop para exibir o menu e processar as opções até que o usuário escolha a opção 0
        do {
            System.out.println(menu);  // Exibe o menu
            System.out.println("Qual a opção desejada?");  // Solicita a escolha da opção

            switch(opcao) {  // Ação de acordo com a opção escolhida
                case 1:
                    inserir(banco);  // Chama o método para inserir uma nova conta
                    break;
                case 2:
                    consultar(banco);  // Chama o método para consultar uma conta
                    break;
                case 3:
                    sacar(banco);  // Chama o método para sacar da conta
                    break;
                case 4:
                    depositar(banco);  // Chama o método para depositar na conta
                    break;
                case 5:
                    excluir(banco);  // Chama o método para excluir uma conta
                    break;
                case 6:
                    transferir(banco);  // Chama o método para transferir valores entre contas
                    break;
                case 7:
                    totalizar(banco);  // Chama o método para realizar totalizações do banco
                    break;
                case 8:
                    inserirClientes(banco);  // Chama o método para inserir um cliente
                    break;
                case 9:
                    consultarClientes(banco);  // Chama o método para consultar um cliente
                    break;
                case 10:
                    associar(banco);  // Chama o método para associar uma conta a um cliente
                    break;
            }
        } while(opcao != 0);  // O loop continua até que o usuário escolha a opção 0
    }

    // Método para inserir uma nova conta
    public static void inserir(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas

        System.out.println("Digite o número da conta: ");
        String numero = in.next();  // Lê o número da conta

        // Cria uma nova conta com o número informado e saldo inicial de 0
        Conta conta = new Conta(numero, 0);

        // Chama o método do banco para inserir a conta
        banco.inserir(conta);
    }

    // Método para consultar uma conta
    public static void consultar(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o número da conta: ");
        String numero = in.next();  // Lê o número da conta

        // Chama o método do banco para consultar a conta com o número informado
        Conta conta = banco.consultar(numero);

        // Exibe as informações da conta
        System.out.println("Essa é a conta \n" + conta.getNumero() + " Saldo de R$ \n" + conta.consultarSaldo());
    }

    // Método para sacar da conta
    public static void sacar(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o número da conta: ");
        String numero = in.next();  // Lê o número da conta

        System.out.println("Digite o valor que deseja sacar: ");
        float valor = in.nextFloat();  // Lê o valor a ser sacado

        // Chama o método do banco para realizar o saque
        banco.sacar(numero, valor);
    }

    // Método para depositar em uma conta
    public static void depositar(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o número da conta que deseja depositar: ");
        String numero = in.next();  // Lê o número da conta

        System.out.println("Digite o valor: ");
        float valor = in.nextFloat();  // Lê o valor a ser depositado

        // Chama o método do banco para realizar o depósito
        banco.depositar(numero, valor);
    }

    // Método para excluir uma conta
    public static void excluir(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas

        System.out.println("Digite o número da conta que deseja excluir: ");
        String numero = in.next();  // Lê o número da conta

        // Chama o método do banco para excluir a conta
        banco.excluir(numero);
    }

    // Método para transferir valores entre contas
    public static void transferir(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas

        System.out.println("Digite o número da conta que deseja transferir o dinheiro: ");
        String numero = in.next();  // Lê o número da conta de origem

        System.out.println("Digite para qual conta deseja transferir: ");
        String numero2 = in.next();  // Lê o número da conta de destino

        System.out.println("Digite o valor: ");
        float valor = in.nextFloat();  // Lê o valor a ser transferido

        // Chama o método do banco para realizar a transferência
        banco.transferir(numero2, numero, valor);
    }

    // Método para exibir a totalização do dinheiro do banco
    public static void totalizar(Banco banco) {
        // Chama o método do banco para exibir a quantidade de dinheiro
        banco.quantidadeDinheiro();
    }

    // Método para inserir um novo cliente no banco
    public static void inserirClientes(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o id do cliente: ");
        String id = in.next();  // Lê o ID do cliente

        System.out.println("Digite o nome do cliente: ");
        String nome = in.next();  // Lê o nome do cliente

        System.out.println("Digite o CPF do cliente: ");
        String cpf = in.next();  // Lê o CPF do cliente

        System.out.println("Digite a data de nascimento do cliente (dd/MM/yyyy): ");
        String data = in.next();  // Lê a data de nascimento do cliente

        // Cria um novo cliente com os dados informados
        Cliente cliente = new Cliente(id, nome, cpf, data);

        // Chama o método do banco para inserir o cliente
        banco.inserirCliente(cliente);
    }

    // Método para consultar informações de um cliente
    public static void consultarClientes(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o CPF do cliente: ");
        String cpf = in.next();  // Lê o CPF do cliente

        // Chama o método do banco para consultar o cliente
        banco.consultarCliente(cpf);
    }

    // Método para associar uma conta a um cliente
    public static void associar(Banco banco) {
        Scanner in = new Scanner(System.in);  // Cria o Scanner para ler as entradas
        System.out.println("Digite o CPF do cliente: ");
        String cpf = in.next();  // Lê o CPF do cliente
        Cliente cliente = banco.consultarCliente(cpf);  // Recupera o cliente com o CPF informado

        System.out.println("Digite o número da conta: ");
        String numero = in.next();  // Lê o número da conta

        Conta conta = banco.consultar(numero);  // Recupera a conta com o número informado

        // Chama o método do banco para associar a conta ao cliente
        banco.associarContaCliente(conta, cliente);
    }
}
