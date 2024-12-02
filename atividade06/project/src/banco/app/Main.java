package banco.app;

import banco.entities.Banco;
import banco.entities.Cliente;
import banco.entities.Conta;

public class Main {
    public static void main(String[] args) {
        Banco bancoJota = new Banco();

        bancoJota.inserirConta(new Conta(1, "123-8", 1000, null));
        bancoJota.inserirConta(new Conta(2, "124-0", 1, null));
        bancoJota.inserirConta(new Conta(3, "136-7", 10, null));

        bancoJota.printContas();
    }
}