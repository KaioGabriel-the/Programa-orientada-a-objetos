package entities.veiculo;

public class Carro extends  Veiculo{
    private String modelo;

    public Carro(){
        modelo = null;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro: \n" +
                "* Placar - "+ getPlacar() +
                "\n* Ano de fabricação - " + getAno() +
                "\n* Modelo - " + modelo;
    }
}
