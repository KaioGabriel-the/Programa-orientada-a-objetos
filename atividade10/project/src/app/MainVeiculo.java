package app;

import entities.veiculo.Carro;
import entities.veiculo.CarroEletrico;
import entities.veiculo.Veiculo;

import java.util.Scanner;

public class MainVeiculo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String menu = "----- MENU ----- \n" +
                "1- Adicionar um veiculo \n"+
                "2- Adicionar Carro norma\n" +
                "3- Adicionar Carro eletrico \n" +
                "0- Sair \n";
        String strOpcao = "Digite qual opção deseja: ";
        int opcao = -1;

        do {
            System.out.println(menu);
            System.out.println(strOpcao);
            opcao = in.nextInt();
            caseMenu(opcao);
        }while (opcao != 0);
    }

    private static void caseMenu(int opcao){
        Scanner in = new Scanner(System.in);
        switch (opcao){
            case 1:
                Veiculo veiculo = new Veiculo();
                System.out.println("Digite a placar do veiculo: ");
                String placar = in.next();
                veiculo.setPlacar(placar);

                System.out.println("Digite o ano de fabricação do veiculo: ");
                int ano = in.nextInt();
                veiculo.setAno(ano);

                System.out.println("Veiculo cadastrado com sucesso...");
                System.out.println(veiculo.toString());
                break;
            case 2:
                Carro carro = new Carro();
                System.out.println("Digite a placar do veiculo: ");
                String placarCarro = in.next();
                carro.setPlacar(placarCarro);

                System.out.println("Digite o ano de fabricação de veiculo: ");
                int anoCarro = in.nextInt();
                carro.setAno(anoCarro);

                System.out.println("Digite o modelo do carro: ");
                String modeloCarro = in.next();
                carro.setModelo(modeloCarro);

                System.out.println("Carro cadastrado com sucesso");
                System.out.println(carro.toString());
                break;
            case 3:
                CarroEletrico carroEletrico = new CarroEletrico();
                System.out.println("Digite a placar do veiculo: ");
                String placarCarroE = in.next();
                carroEletrico.setPlacar(placarCarroE);

                System.out.println("Digite o ano de fabricação de veiculo: ");
                int anoCarroE = in.nextInt();
                carroEletrico.setAno(anoCarroE);

                System.out.println("Digite o modelo do carro: ");
                String modeloCarroE = in.next();
                carroEletrico.setModelo(modeloCarroE);

                System.out.println("Digite a autonomia do carro: ");
                int autonomiaCarro = in.nextInt();
                carroEletrico.setAutonomiabateria(autonomiaCarro);

                System.out.println("Carro eletrico cadastrado com sucesso");
                System.out.println(carroEletrico.toString());
                break;
        }
    }
}
