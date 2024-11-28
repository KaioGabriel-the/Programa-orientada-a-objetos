package banco.entities;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    List<Conta> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public void inserir(Conta conta){
        contas.add(conta);
    }

    public List<Conta> getContas(){
        return contas;
    }
}
