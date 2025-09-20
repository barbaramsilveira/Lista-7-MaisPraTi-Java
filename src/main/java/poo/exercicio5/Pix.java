package poo.exercicio5;
import java.math.BigDecimal;

public class Pix extends FormaPagamento{
    private String tipoChave;
    private String nomeOrigem;
    private String nomeDestino;
    private String chaveOrigem;
    private String chaveDestino;
    private BigDecimal valor;

    public String getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }

    public String getNomeOrigem() {
        return nomeOrigem;
    }

    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getChaveOrigem() {
        return chaveOrigem;
    }

    public void setChaveOrigem(String chaveOrigem) {
        this.chaveOrigem = chaveOrigem;
    }

    public String getChaveDestino() {
        return chaveDestino;
    }

    public void setChaveDestino(String chaveDestino) {
        this.chaveDestino = chaveDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public void validarPagamento() throws ValorNuloException, ChaveNulaException {
        if(valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new ValorNuloException("Valor não pode ser igual a zero!");
        if (chaveOrigem == null || chaveOrigem.isBlank()) {
            throw new ChaveNulaException("A chave de origem não pode estar vazia!");
        }
        if (chaveDestino == null || chaveDestino.isBlank()) {
            throw new ChaveNulaException("A chave de destino não pode estar vazia!");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws ValorNuloException, ChaveNulaException {
        validarPagamento();
        System.out.println("Pix enviado de " + nomeDestino + " para " + nomeOrigem + " no valor de " + valor + " reais processado com sucesso!");

    }
}

