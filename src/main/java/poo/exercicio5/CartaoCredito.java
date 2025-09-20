package poo.exercicio5;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento{
    private String numeroCartao;
    private String nomeTitular;
    private BigDecimal limite;
    private BigDecimal valorTransacao;


    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
    @Override
    public void validarPagamento() throws LimiteInsuficienteException {
        if (valorTransacao == null || valorTransacao.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da transação deve ser maior que zero!");
        }
        if (valorTransacao.compareTo(limite) > 0) {
            throw new LimiteInsuficienteException("Seu limite é insuficiente para essa transação!");
        }
    }
    @Override
    public void processarPagamento(BigDecimal valor) throws LimiteInsuficienteException {
        validarPagamento();
        if (valor.compareTo(limite) > 0) {
            throw new LimiteInsuficienteException("Seu limite é insuficiente para essa transação!");
        }
        limite = limite.subtract(valor);
        valorTransacao = valor;
        System.out.println("Pagamento de " + valor + " reais realizado com sucesso para o cartão de " + nomeTitular + "!");
    }
}

