package entities.estoque;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ProdutoPerecivel extends Produto {
    private Date validade;

    public ProdutoPerecivel() {
        super();
        this.validade = new Date();
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        // Formatar a data de validade
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String validadeFormatada = formato.format(validade);


        return "---- Produto Perecivel ---- \n" +
                "codigo: " + codigo + "\n" +
                "descricao: " + descricao + "\n" +
                "quantidade: " + quantidade + "\n" +
                "validade --> " + validade;
    }

    public boolean Valido() {
        return  this.validade.before(new Date());
    }

    @Override
    public void repor ( int qtdProuduto){
        Scanner in = new Scanner(System.in);
        Date dataAtual = new Date();

        if (Valido()) {
            super.repor(qtdProuduto);
            System.out.println("Reposição feita com sucesso");
        } else {
            System.out.println("Produto invalido, não foi possivel repor");
        }
    }

    @Override
    public void darBaixa(int qtdProuduto) {
        Scanner in = new Scanner(System.in);
        Date dataAtual = new Date();

        if (Valido()) {
            super.darBaixa(qtdProuduto);
            System.out.println("Produto contabilizado com sucesso");
        } else {
            System.out.println("Produto invalido, não foi possivel contabilizar");
        }
    }
}