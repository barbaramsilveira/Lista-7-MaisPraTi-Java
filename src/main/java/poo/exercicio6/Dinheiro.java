package poo.exercicio6;

import java.math.BigDecimal;
import java.util.Objects;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) throws ValorInvalidoException {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException("Valor inválido");
        }
        if (moeda == null) {
            throw new IllegalArgumentException("Moeda não pode ser nula");
        }
        this.valor = valor;
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dinheiro)) return false;
        Dinheiro dinheiro = (Dinheiro) obj;
        return valor.equals(dinheiro.valor) && moeda.equals(dinheiro.moeda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return valor + " " + moeda;
    }
}
