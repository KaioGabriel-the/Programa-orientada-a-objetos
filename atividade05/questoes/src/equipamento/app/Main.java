package equipamento.app;

import equipamento.entities.Funcionalidades;

public class Main {

    public static void main(String[] args){
        Funcionalidades equipamento = new Funcionalidades();

        equipamento.ligar();
        equipamento.desligar();
        equipamento.inverter();
        equipamento.estaLigado();
    }
}
