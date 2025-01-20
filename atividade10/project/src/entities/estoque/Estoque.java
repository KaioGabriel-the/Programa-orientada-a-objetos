package entities.estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public boolean verificacao(int codigo,  String descricao) {
        for (Produto produto : this.produtos) {
            if (produto.getCodigo() == codigo && produto.getDescricao().equals(descricao)) {
                return true;
            }
        }
        return false;
    }

    public void inserirProduto(Produto produto) {
        if (!verificacao(produto.getCodigo(), produto.getDescricao())) {
            produtos.add(produto);
            System.out.println("Produto inserido com sucesso!");
        }else {
            System.out.println("Já existe um produto com esse codigo ou descrição");
        }
    }

    public Produto consultarProdutoPorCodigo(int codigoProduto) {
        for (Produto produto : this.produtos) {
            if(produto.getCodigo() == codigoProduto){
                return produto;
            }
        }
        return null;
    }

    public void removerProduto(Produto produto) {
        if(produto !=null){
            this.produtos.remove(produto);
        }
    }

    public void reporProdutoPorCodigo(int codigoProduto, int quantidade) {
        Produto produto = consultarProdutoPorCodigo(codigoProduto);
        if(produto != null){
            produto.repor(quantidade);
            System.out.println("Produto reposto com sucesso!");
        }
    }

    public void darBaixaProduto(int codigoProduto, int quantidade) {
        Produto produto = consultarProdutoPorCodigo(codigoProduto);
        if(produto != null){
            produto.darBaixa(quantidade);
            System.out.println("Produto dado baixa com sucesso!");
        }
    }

    public void imprimirListaProdutos(List<ProdutoPerecivel> produtosPerecivel) {
       for (Produto produto : produtosPerecivel) {
           System.out.println(produto.toString());
       }
    }

    public void listarProdutosInvalidos() {
        List<Produto> produtosInvalidos = new ArrayList<>();

        for (Produto produto : this.produtos) {
            if(produto instanceof ProdutoPerecivel){
                if(((ProdutoPerecivel) produto).Valido()){
                    produtosInvalidos.add(produto);
                }
            }
        }

    }

}
