package entities.veiculo;

public class CarroEletrico extends Carro{
    private int autonomiabateria;

    public CarroEletrico(){
        autonomiabateria = 0;
    }

    public int getAutonomiabateria() {
        return autonomiabateria;
    }

    public void setAutonomiabateria(int autonomiabateria) {
        this.autonomiabateria = autonomiabateria;
    }

    @Override
    public String toString() {
        return "Carro Eletrico: \n" + "* Placar - " + getPlacar() +
                "\n* Ano - " + getAno() + "\n* Modelo - " + getModelo() +
                "\n* Autonomia da bateria - " + autonomiabateria;
    }
}
