package poo.exercicio8;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculadoraFrete {
    BigDecimal calcular(Pedido pedido) throws CepInvalidoException;
}
