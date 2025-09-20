package poo.exercicio4;
public interface IMeioTransporte {
    void acelerar() throws IllegalStateException;
    void frear()throws IllegalStateException;
    int getVelocidade();
}
