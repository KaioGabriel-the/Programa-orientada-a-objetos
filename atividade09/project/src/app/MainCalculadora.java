package app;

import entities.Calculadora;
import entities.Hora;

public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(1,2);
        System.out.println(calculadora.somar());
        System.out.println(calculadora.subtrair());
//        System.out.println(calculadora.operation1);
        //Não é possivel acesar o atributo;

        Hora hora = new Hora(1,20,30);
        System.out.println(hora.getHora());
        System.out.println(hora.getMinuto());
        System.out.println(hora.getSegundos());
    }
}
