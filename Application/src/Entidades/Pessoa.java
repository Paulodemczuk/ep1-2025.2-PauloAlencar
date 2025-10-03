package Entidades;
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(){
        this.nome = "";
        this.idade = 0;
    }
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    };
    public void setIdade(int idade) {
        this.idade = idade;
    };

    public String getNome(){
        return this.nome;
    }
    public int getIdade(){
        return this.idade;
    }

    public void printInformacoes(){
        System.out.println("----------------------");
        System.out.println("nome:"+ this.nome);
        System.out.println("idade:"+ this.idade);
        System.out.println("----------------------");
    }
}
