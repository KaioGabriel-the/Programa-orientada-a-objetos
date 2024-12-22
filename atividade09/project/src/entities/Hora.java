package entities;

public class Hora {
    private int hora;
    private int minuto;
    private int segundos;

    public Hora(int hora, int minuto, int segundos) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundos = segundos;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundos() {
        return segundos;
    }
}
