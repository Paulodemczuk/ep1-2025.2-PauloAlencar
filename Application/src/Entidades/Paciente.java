package Entidades;

import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String cpf;
    private ArrayList<Consulta> consultas;
    private ArrayList<Internacao> internacoes;
    
    public Paciente(){
        super();
        this.cpf = "";
        this.consultas = new ArrayList<>();
        this.internacoes = new ArrayList<>();
        
    }
    public Paciente(String nome, int idade, String telefone, String cpf){
        super(nome, idade, telefone);
        this.cpf = cpf;
        this.consultas = new ArrayList<>();
        this.internacoes = new ArrayList<>();
    }
    public void setCpf(String cpf){
        this.cpf = cpf;    
    }
    public String getCpf(){
        return this.cpf;
    }

    public void adicionarConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }

    public void adicionarInternacao(Internacao internacao){
        this.internacoes.add(internacao);
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

    @Override
    public String toString(){
        return "---------------------\nNome: "+ this.getNome() +"\nIdade: "+ this.getIdade() + "\nCPF: " + this.getCpf() + "\n---------------------\n";
    }
}
