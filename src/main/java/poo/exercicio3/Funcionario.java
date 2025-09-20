package poo.exercicio3;

import java.math.BigDecimal;

abstract class Funcionario {
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        if(salario.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Salário deve ser positivo");

        }
        this.nome = nome;
        this.salario = salario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public abstract BigDecimal calcularBonus();
}
