import java.util.Scanner;
//classe Candidato com atributos e métodos que serão utilizados no programa urna

public class Candidato extends Pessoa {
    // definição de variáveis da classe
    private int numero;
    private Cargo cargo;
    private int numVotos;

    //atribuição de valores do objeto por parâmetro
public Candidato ( String nome, int numero, Cargo cargo) {
    this.nome = nome;
    this.numero = numero;
    this.cargo = cargo;
     }

    // método que soma os votos
    public void receberVoto() {
        numVotos++;
    }

    //métodos que retornam o valor dos atributos
    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroVotos() {
        return numVotos;
    }

    public Cargo getCargo() {
        return cargo;
    }

}