import entities.Banco;
import entities.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banco banco = new Banco();
        String menu = "----- Menu -----" + "\n" +
                "1- Cadastrar Nova Conta;" + "\n" +
                "2- Depositar;" + "\n" +
                "3- Sacar;" + "\n" +
                "4- Transferir;" + "\n" +
                "5- Listar Contas;" + "\n" +
                "0- Sair " + "\n";
        int opc = -1;
        do{
            System.out.println(menu);
            System.out.println("Escolha uma opcao: ");
            opc = in.nextInt();

            switch (opc){
                case 1:
                    cadastrarConta(banco);
                    break;
                case 2:
                    depositarConta(banco);
                    break;
                case 3:
                    sacarConta(banco);
                    break;
                case 4:
                    transferirConta(banco);
                    break;
                case 5:
                    listarContas(banco);
                    break;
            }
        }while(opc != 0);
    }

    private static void cadastrarConta(Banco banco){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o id da conta: ");
        int id = in.nextInt();
        System.out.println("Digite o numero da conta: ");
        String numero = in.next();
        System.out.println("Digite o saldo da conta: ");
        float saldo = in.nextFloat();
        banco.adicionarConta(id,numero,saldo);
    }

    private static void depositarConta(Banco banco){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        String numero = in.next();
        Conta conta = banco.procurarConta(numero);
        System.out.println("Digite o valor que deseja depositar: ");
        float valor = in.nextFloat();

        if(conta != null){
            banco.depositar(conta,valor);
        }
    }

    private static void sacarConta(Banco banco){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        String numero = in.next();
        Conta conta = banco.procurarConta(numero);
        System.out.println("Digite o valor que deseja sacar: ");
        float valor = in.nextFloat();

        if(conta != null){
            banco.sacar(conta,valor);
        }
    }

    private static void transferirConta(Banco banco){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero da conta que deseja transferir: ");
        String numeroEnviador = in.next();
        Conta contaEnviador = banco.procurarConta(numeroEnviador);
        System.out.println("Digite a conta para qual deseja transferir: ");
        String numeroDestino = in.next();
        Conta contaDestino = banco.procurarConta(numeroDestino);
        System.out.println("Digite o valor que deseja sacar: ");
        float valorDestino = in.nextFloat();

        if(contaDestino != null && contaEnviador != null){
            banco.transferir(contaEnviador,contaDestino,valorDestino);
        }
    }

    private static void listarContas(Banco banco){
        banco.imprirContas();
    }
}