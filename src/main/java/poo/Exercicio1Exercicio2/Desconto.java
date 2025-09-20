package poo.Exercicio1Exercicio2;

public class Desconto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private int porcentagem;

    public Desconto(String nome, double preco, int quantidadeEmEstoque, int porcentagem) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setPorcentagem(porcentagem);
    }


    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Desconto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha o nome do produto!");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero!");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if(quantidadeEmEstoque < 0){
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero!");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void exibeInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Quantidade: " + quantidadeEmEstoque);
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("O desconto deve estar entre 0% e 50%");
        }
        preco = preco * (1 - porcentagem / 100);
    }

    public static void main(String[] args) {
        Desconto produto = new Desconto("Calça Jeans", 500, 5, 50);
        System.out.println("Preço antes do desconto: " + produto.getPreco());

        produto.aplicarDesconto(50);
        System.out.println("Preço depois do desconto de " + produto.porcentagem + "%: " + produto.getPreco());

        try {
            produto.aplicarDesconto(60); // desconto inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
