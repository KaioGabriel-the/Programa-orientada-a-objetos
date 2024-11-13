package reservahotel.app;
import reservahotel.entities.Reserva;

public class Main {
    public static void main(String[] args) {
        Reserva reserva = new Reserva(2);
        System.out.println(reserva.quantReserva());
    }
}