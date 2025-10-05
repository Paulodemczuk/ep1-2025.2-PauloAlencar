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
    public Paciente(String nome, int idade, String cpf){
        super(nome, idade);
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
        System.out.println("CPF: "+ this.cpf);
        System.out.println("----------------------");
    }

    @Override
    public String toString(){
        return "---------------------\nNome: "+ this.getNome() +"\nIdade: "+ this.getIdade() + "\nCPF: " + this.getCpf() + "\n---------------------\n";
    }

    public void printInternacoes(){
        System.out.println();
        for(Internacao internacao : internacoes){
            System.out.println(internacao.getIdInternacao());
            System.out.println(internacao.getMedico().getNome());
            System.out.println(internacao.getPaciente().getNome());
            System.out.println(internacao.getQuarto());
            System.out.println(internacao.getDataEntradaFormatada());
            System.out.println(internacao.getDataSaidaFormatada());
            System.out.println(internacao.getDuracaoInternacao());
            System.out.println(internacao.getCustoInternacao());
            System.out.println();
        }
    }
}
