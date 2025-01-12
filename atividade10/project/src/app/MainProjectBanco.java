package app;
import entities.banco.*;
import java.util.Scanner;

public class MainProjectBanco {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner in = new Scanner(System.in);
        String menu = "----- MENU -----\n"
                + "1 - Cadastrar Conta\n"
                + "2 - Cadastrar Cliente\n"
                + "3 - Cadastrar Poupanca\n"
                + "4 - Cadastrar Conta Imposto\n"
                + "5 - Salvar em documento\n";
        int opc = -1;

        do {
            System.out.println(menu);
            System.out.println("Digite qual opção deseja: ");
            opc = in.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Digite o numero da conta: ");
                    String numeroConta = in.nextLine();
                    System.out.println("Digite o saldo da conta: ");
                    double saldoConta = in.nextDouble();
                    Conta conta = new Conta(numeroConta,saldoConta);
                    banco.inserirConta(conta);
                    System.out.println("Conta cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = in.nextLine();
                    System.out.println("Digite o cpf do cliente: ");
                    String cpfCliente = in.nextLine();
                    System.out.println("Digite a data de nascimento: ");
                    String dataNascimento = in.nextLine();
                    Cliente cliente = new Cliente(nomeCliente,cpfCliente,dataNascimento);
                    banco.inserirCliente(cliente);
                    System.out.println("Cliente cadastrada com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o numero da conta poupanca: ");
                    String numeroContaPoupanca = in.nextLine();
                    System.out.println("Digite o saldo da conta: ");
                    double saldoContaPoupanca = in.nextDouble();
                    System.out.println("Digite o juros da conta: ");
                    double jurosContaPoupanca = in.nextDouble();
                    Poupanca poupanca = new Poupanca(numeroContaPoupanca,saldoContaPoupanca,jurosContaPoupanca);
                    banco.inserirConta(poupanca);
                    System.out.println("Conta cadastrada com sucesso!");
                    break;
                case 4:
                    System.out.println("Digite o numero da conta imposto: ");
                    String numeroContaImposto = in.nextLine();
                    System.out.println("Digite o saldo da conta: ");
                    double saldoContaImposto = in.nextDouble();
                    System.out.println("Digite o valor do imposto: ");
                    double valorImposto = in.nextDouble();
                    ContaImposto contaImposto = new ContaImposto(numeroContaImposto,saldoContaImposto,valorImposto);
                    banco.inserirConta(contaImposto);
                    System.out.println("Conta cadastrada com sucesso!");
                    break;
            }
        } while (opc != 0);

    }
}
