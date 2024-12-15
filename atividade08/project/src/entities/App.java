package entities;

import org.w3c.dom.ls.LSOutput;

public class App {
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
            "10- Pagamentos multiplos"
            + "Cliente: \n"
            + "11- Cadastrar cliente\n"
            + "12- Listar cliente\n" +
            "13- Listar clientes\n" +
            "14- alterar dados de cliente\n" +
            "15- Lincar conta ao cliente\n" +
            "16- Excluir cliente\n" +
            "17- Listar contas de cliente\n"
            ;
}
