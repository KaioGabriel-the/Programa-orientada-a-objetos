package jogador.entities;

public class Jogador {
    public float nivel;
    public float forca;
    public float pontosAtuais;

    public Jogador(float nivel, float forca, float pontosAtuais){
        this.nivel = nivel;
        this.forca = forca;
        this.pontosAtuais = pontosAtuais;
    }

    public float calcularDano(){
        return forca * nivel;
    }

    public void ataque(Jogador inimigo){
        if(inimigo.estaVivo(inimigo)){
            inimigo.pontosAtuais -= this.calcularDano();
        }
    }

    public boolean estaVivo(Jogador jagador){
        if(jagador.pontosAtuais < 0){
            return false;
        }else{
            return true;
        }
    }

    public String toString(){
        return "Nivel: " + nivel + " Força: " + forca + " Pontos Atuais: " + pontosAtuais;
    }
}
