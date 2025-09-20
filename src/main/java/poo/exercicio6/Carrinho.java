package poo.exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal desconto;

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.desconto = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal desconto) {
        this.itens = Collections.unmodifiableList(itens);
        this.desconto = desconto;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        if (item == null) throw new IllegalArgumentException("Item não pode ser nulo");
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.add(item);
        return new Carrinho(novaLista, desconto);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        if (item == null) throw new IllegalArgumentException("Item não pode ser nulo");
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.remove(item);
        return new Carrinho(novaLista, desconto);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual == null) throw new IllegalArgumentException("Percentual não pode ser nulo");
        BigDecimal max = new BigDecimal("0.30");
        BigDecimal p = percentual;
        if (p.compareTo(max) > 0) {
            p = max;
        }
        p = p.setScale(2, RoundingMode.HALF_EVEN);
        return new Carrinho(itens, p);
    }

    public Carrinho aplicarDesconto(BigDecimal percentual) {
        return aplicarCupom(percentual);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : itens) {
            BigDecimal subtotal = item.getProduto().getPreco().getValor()
                    .multiply(BigDecimal.valueOf(item.getQuantidade()));
            total = total.add(subtotal);
        }
        if (desconto.compareTo(BigDecimal.ZERO) > 0) {
            total = total.multiply(BigDecimal.ONE.subtract(desconto));
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}
