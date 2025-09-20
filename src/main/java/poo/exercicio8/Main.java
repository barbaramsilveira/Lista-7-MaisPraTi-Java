package poo.exercicio8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws CepInvalidoException {
        Pedido pedido = new Pedido();
        pedido.setCep("93540-183");
        pedido.setTotal(new BigDecimal("150"));

        pedido.setFreteStrategy(new Sedex());
        System.out.println("Frete Sedex: " + pedido.calcularFrete());

        pedido.setFreteStrategy(new Pac());
        System.out.println("Frete PAC: " + pedido.calcularFrete());

        pedido.setFreteStrategy(new RetiradaNaLoja());
        System.out.println("Frete RetiradaNaLoja: " + pedido.calcularFrete());

        CalculadoraFrete fretePromocional = p -> {
            p.validarCep();
            if (p.getTotal().compareTo(new BigDecimal("150")) >= 0) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal("10.00");
        };
        pedido.setFreteStrategy(fretePromocional);
        System.out.println("Frete promocional: " + pedido.calcularFrete());

        try {
            pedido.setCep("989-000");
            pedido.setFreteStrategy(new Sedex());
            System.out.println(pedido.calcularFrete());
        } catch (CepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}