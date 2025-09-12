package Entidades;
public class Pessoa {
    private String nome;
    private int idade;
    private String telefone;

    public Pessoa(){
        this.nome = "";
        this.idade = 0;
        this.telefone = "";
    }
    public Pessoa(String nome, int idade, String telefone){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }
    public void setNome(String nome) {
        this.nome = nome;
    };
    public void setIdade(int idade) {
        this.idade = idade;
    };
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    };
    public String getNome(){
        return this.nome;
    }
    public int getIdade(){
        return this.idade;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void printInformacoes(){
        System.out.println("----------------------");
        System.out.println("nome:"+ this.nome);
        System.out.println("idade:"+ this.idade);
        System.out.println("telefone:"+ this.telefone);
        System.out.println("----------------------");
    }
}
