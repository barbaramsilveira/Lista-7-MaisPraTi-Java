package poo.exercicio5;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto extends FormaPagamento {
    private String codigoBarras;
    private BigDecimal valor;
    private String nomeBeneficiario;
    private String nomePagador;
    private LocalDate dataVencimento;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    @Override
    public void validarPagamento() {
        if (codigoBarras.length() != 16) {
            throw new NumeroBoletoInvalidoException("Número do boleto inválido!");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento processado com sucesso!");
    }
}