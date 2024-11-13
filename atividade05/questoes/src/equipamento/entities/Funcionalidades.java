package equipamento.entities;

public class Funcionalidades {
    private boolean ligado;

    public boolean getLigado(){
        return ligado;
    }
    public void ligar(){
        if(ligado == true){
            ligado = false;
        }else {
            ligado = true;
        }
    }

    public void desligar(){
        if(ligado == false){
            ligado = true;
        }else {
            ligado = false;
        }
    }

    public void inverter(){
        ligado = !ligado;
    }

    public void estaLigado(){
        System.out.println(ligado ? "Ligado" : "Desligado");
    }
}
