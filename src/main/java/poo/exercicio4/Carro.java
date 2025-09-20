package poo.exercicio4;

public class Carro implements IMeioTransporte {
    private int velocidade;
    private final int velocidadeMaxima;

    public Carro() {
        this.velocidade = 0;
        this.velocidadeMaxima = 180;
    }
    @Override
    public void acelerar() {
        if (this.velocidade < this.velocidadeMaxima) {

            this.velocidade += 10;
            System.out.println("Velocidade do Carro após acelerar: " + this.velocidade);
        } else {
            throw new IllegalArgumentException("Velocidade do Carro acima do permitido!");
        }
    }

    @Override
    public void frear() {
        if(this.velocidade > 0 ){
            this.velocidade -= 10;
            System.out.println("Velocidade do Carro após frear: " + this.velocidade);
        }
    }
    @Override
    public int getVelocidade() {
        return velocidade;
    }
}
