package poo.exercicio5;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        FormaPagamento cartao = new CartaoCredito();
        ((CartaoCredito) cartao).setNomeTitular("Amelie");
        ((CartaoCredito) cartao).setLimite(new BigDecimal("1000"));
        ((CartaoCredito) cartao).setValorTransacao(new BigDecimal("0"));

        FormaPagamento pix = new Pix();
        ((Pix) pix).setNomeOrigem("Charlotte");
        ((Pix) pix).setNomeDestino("Maria");
        ((Pix) pix).setChaveOrigem("12345678901");
        ((Pix) pix).setChaveDestino("09876543210");
        ((Pix) pix).setValor(new BigDecimal("100"));

        FormaPagamento boleto = new Boleto();
        ((Boleto) boleto).setNomePagador("Ana");
        ((Boleto) boleto).setNomeBeneficiario("Loja");
        ((Boleto) boleto).setCodigoBarras("1234567890123456");
        ((Boleto) boleto).setValor(new BigDecimal("100"));

        FormaPagamento[] pagamentos = {cartao, pix, boleto};

        for (FormaPagamento pagamento : pagamentos) {
            try {
                pagamento.validarPagamento();
                pagamento.processarPagamento(
                        pagamento instanceof CartaoCredito ?
                                ((CartaoCredito) pagamento).getValorTransacao() :
                                pagamento instanceof Pix ?
                                        ((Pix) pagamento).getValor() :
                                        ((Boleto) pagamento).getValor()
                );
            } catch (ValorNuloException | LimiteInsuficienteException | ChaveNulaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}