package Entidades;

public class Paciente extends Pessoa {
    public String cpf;
    
    public Paciente(){
        super();
        this.cpf = "";
        
    }
    public Paciente(String nome, int idade, String telefone, String cpf){
        super(nome, idade, telefone);
        this.cpf = cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;    
    }
    public String getCpf(){
        return this.cpf;
    }
    
    @Override
    public void printInformacoes(){
        System.out.println("----------------------");
        System.out.println("nome:"+ this.getNome());
        System.out.println("idade:"+ this.getIdade());
        System.out.println("telefone:"+ this.getTelefone());
        System.out.println("CPF: "+ this.cpf);
        System.out.println("----------------------");
    }
}
