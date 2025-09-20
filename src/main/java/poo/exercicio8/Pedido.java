package poo.exercicio8;

import java.math.BigDecimal;

public class Pedido {
    private String cep;
    private BigDecimal total;
    private CalculadoraFrete freteStrategy;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public CalculadoraFrete getFreteStrategy() {
        return freteStrategy;
    }

    public void setFreteStrategy(CalculadoraFrete strategy) {
        this.freteStrategy = strategy;
    }

    public void validarCep() throws CepInvalidoException {
        if (cep == null || !cep.matches("\\d{5}-\\d{3}")) {
            throw new CepInvalidoException("CEP inválido: " + cep);
        }
    }
    public BigDecimal calcularFrete() throws CepInvalidoException {
        if (freteStrategy == null) {
            throw new CepInvalidoException("Por favor, preencha o tipo de Cep, nenhum tipo de frete escolhido!");
        }
        return freteStrategy.calcular(this);
    }
}
