package entities.estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto produto) {}

    public void removerProduto(Produto produto) {}

    public void consularProdutoPorCodigo(String codigoProduto) {}

    public void reporProdutoPorCodigo(String codigoProduto) {}

    public void darBaixaProduto(String codigoProduto) {}


}
