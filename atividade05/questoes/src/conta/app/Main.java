package conta.app;
import conta.entities.Conta;
public class Main {
    public static void main(String[] args){
        Conta conta01 = new Conta("conta01",1000);
        Conta conta02 = new Conta("conta02",1000);

        conta01.sacar(100);
        conta02.depositar(50);
        conta02.transferir(conta01,100);
    }
}
