package poo.Exercicio1Exercicio2;
public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public Produto() {
    }

    public static void main(String[] args) {
        try{
            Produto produtoNovo = new Produto("Calça Jeans", 300.00, 2);
            produtoNovo.exibeInfo();
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
        }

        try{
            Produto produtoNovo = new Produto("", 1, 2);
            produtoNovo.exibeInfo();
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
        }
        try{
            Produto produtoNovo = new Produto("Boneca", -1, 2);
            produtoNovo.exibeInfo();
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
        }

        try{
            Produto produtoNovo = new Produto("Brinquedo", 1, -5);
            produtoNovo.exibeInfo();
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
        }
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
}


