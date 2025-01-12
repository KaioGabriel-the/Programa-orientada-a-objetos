package app;

import entities.calculadora.CalculadoraCm;
import entities.calculadora.CalcularoaCientifica;

import java.util.Scanner;

public class MainProjectCalculadora {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String menu = "----- Menu -----\n" +
                "1 - Calculadora comum \n" +
                "2 - Calculadora cientifica \n" +
                "0 - Sair \n";
        String calculadoraCm = "----- Calculadora Comum -----\n" +
                "1 - Somar \n" +
                "2 - Subtrair \n" +
                "3 - Multiplicar \n" +
                "4 - Divisão \n" +
                "0 - Sair \n";
        String calculadoraCi = "----- Calculadora Cientifica -----\n" +
                "1 - Somar \n" +
                "2 - Subtrair \n" +
                "3 - Multiplicar \n" +
                "4 - Divisão \n" +
                "5 - Potencia \n" +
                "0 - Sair \n";
        int opc = -1;

        while (opc != 0) {
            System.out.println(menu);
            opc = in.nextInt();

            switch (opc){
                case 1:
                    System.out.println(calculadoraCm);
                    int opc2 = in.nextInt();
                    calculadoraCmm(opc2);
                    break;
                case 2:
                    System.out.println(calculadoraCi);
                    opc2 = in.nextInt();
                    calculadoraCit(opc2);
                    break;
            }
        }
    }

    private static void calculadoraCmm(int opc) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        double numeroum = in.nextDouble();
        System.out.println("Digite o segundo valor: ");
        double numerodois = in.nextDouble();
        CalculadoraCm calculadoraCm = new CalculadoraCm(numeroum, numerodois);

        switch (opc) {
            case 1:
                calculadoraCm.somar();
                break;
            case 2:
                calculadoraCm.subtrair();
                break;
            case 3:
                calculadoraCm.multiplicar();
                break;
            case 4:
                calculadoraCm.dividir();
                break;
        }
    }

    private static void calculadoraCit(int opc) {
        Scanner in = new Scanner(System.in);

        switch (opc) {
            case 1:
                calculadoraCmm(opc);
                break;
            case 2:
                calculadoraCmm(opc);
                break;
            case 3:
                calculadoraCmm(opc);
                break;
            case 4:
                calculadoraCmm(opc);
                break;
            case 5:
                System.out.println("Digite a base: ");
                double numerodois = in.nextDouble();
                System.out.println("Digite o exponente: ");
                double numerodois2 = in.nextDouble();
                CalcularoaCientifica calcularoaCientifica = new CalcularoaCientifica(numerodois, numerodois2);
                calcularoaCientifica.pontecia();
                break;
        }
    }
}
