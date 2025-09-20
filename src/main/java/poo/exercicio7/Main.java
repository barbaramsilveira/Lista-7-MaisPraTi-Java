package poo.exercicio7;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        IRepository<Produto, Integer> produtoRepo = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioRepo = new InMemoryRepository<>();

        Produto p1 = new Produto(1, "Livro Dracula", 100.0);
        Produto p2 = new Produto(2, "Livro Harry Potter", 150.0);

        produtoRepo.salvar(p1);
        produtoRepo.salvar(p2);

        System.out.println("=== Produtos ===");
        for (Produto produto : produtoRepo.listarTodos()) {
            System.out.println(produto.getId() + " - " + produto.getNome() + " - " + produto.getPreco());
        }

        Optional<Produto> busca = produtoRepo.buscarPorId(1);
        busca.ifPresent(p -> System.out.println("Produto encontrado: " + p.getNome()));

        try {
            produtoRepo.remover(2);
            System.out.println("Produto 2 removido com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            produtoRepo.remover(10);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Funcionario f1 = new Funcionario("F001", "Bárbara", 5000);
        Funcionario f2 = new Funcionario("F002", "Amelie", 3000);

        funcionarioRepo.salvar(f1);
        funcionarioRepo.salvar(f2);

        System.out.println("\n=== Funcionários ===");
        for (Funcionario f : funcionarioRepo.listarTodos()) {
            System.out.println(f.getId() + " - " + f.getNome() + " - " + f.getCargo());
        }

        funcionarioRepo.buscarPorId("F002").ifPresent(f ->
                System.out.println("Funcionário encontrado: " + f.getNome())
        );

        try {
            funcionarioRepo.remover("F001");
            System.out.println("Funcionário F001 removido com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
