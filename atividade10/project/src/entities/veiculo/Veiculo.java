package entities.veiculo;

public class Veiculo {
    private String placar;
    private int ano;

    public Veiculo(){
        placar = null;
        ano = 0;
    }

    public String getPlacar() {
        return placar;
    }

    public int getAno() {
        return ano;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        String str = "Veiculo: \n" + "* Placar - " + getPlacar() +"\n* Ano de fabricação: " + getAno();
        return str;
    }
}
