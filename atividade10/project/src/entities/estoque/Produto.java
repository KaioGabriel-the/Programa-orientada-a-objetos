package entities.estoque;

public class Produto {
    protected int codigo;
    protected String descricao;
    protected int quantidade;
    protected double valor;

    public Produto(){
        this.codigo = 0;
        this.descricao = "";
        this.quantidade = 0;
        this.valor = 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "---- Produto ---- \n" +
                "codigo -->" + codigo +
                "\nquantidade --->" + quantidade +
                "\ndescricao --> " + descricao +
                "\n valor --> " + valor +
                '\n';
    }

    public void repor(int qtdProudutos){
        int qtdNova = getQuantidade() + qtdProudutos;
        setQuantidade(qtdNova);
        System.out.println("Produto(s) reposto(s) com sucesso!");
    }

    public void darBaixa(int qtdProudutos){
        int qtdNova = getQuantidade() - qtdProudutos;
        setQuantidade(qtdNova);
        System.out.println("Produto(s) retirado(s) com sucesso!");
    }
}
