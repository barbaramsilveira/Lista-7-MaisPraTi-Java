package poo.exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Isa", new BigDecimal("10000")));
        funcionarios.add(new Desenvolvedor("Charlotte", new BigDecimal("8000")));
        funcionarios.add(new Gerente("Barbara", new BigDecimal("20000")));
        funcionarios.add(new Desenvolvedor("Gabriela", new BigDecimal("7500")));

        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Salário: R$ " + f.getSalario());
            System.out.println("Bônus: R$ " + f.calcularBonus());
            System.out.println("--------------------------");
        }
    }
}