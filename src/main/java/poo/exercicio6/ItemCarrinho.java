package poo.exercicio6;

public class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) throws QuantidadeNulaException {
        if(quantidade <= 0) {
            throw new QuantidadeNulaException("Quantidade não pode ser menor que 0!");
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
}