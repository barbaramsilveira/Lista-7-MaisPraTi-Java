package poo.exercicio8;

import java.math.BigDecimal;

public class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) throws CepInvalidoException {
        pedido.validarCep();
        return new BigDecimal("50.00");
    }
}

