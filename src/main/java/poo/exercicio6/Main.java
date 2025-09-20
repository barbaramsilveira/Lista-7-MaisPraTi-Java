package poo.exercicio6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Bota coturno", new Dinheiro(new BigDecimal("500.00"), Moeda.BRL));
        Produto p2 = new Produto("Vestido Xadrez", new Dinheiro(new BigDecimal("300.00"), Moeda.BRL));

        ItemCarrinho i1 = new ItemCarrinho(p1, 1);
        ItemCarrinho i2 = new ItemCarrinho(p2, 1);

        Carrinho carrinho = new Carrinho();
        carrinho = carrinho.adicionarItem(i1)
                .adicionarItem(i2)
                .aplicarDesconto(new BigDecimal("0.2"));

        System.out.println("Itens no carrinho: " + carrinho.getItens().size());
        System.out.println("Total com desconto: " + carrinho.calcularTotal());
    }
}
