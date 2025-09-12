package Entidades;

public class Medico extends Pessoa{
    private String especialidade;
    private String crm;
    private int custoConsulta;

    public Medico(){
        super();
        this.especialidade = "";
        this.crm = "";
        this.custoConsulta = 0;
    }

    public Medico(String nome, int idade, String telefone, String especialidade, String crm, int custoConsulta){
        super(nome, idade, telefone);
        this.especialidade = especialidade;
        this.crm = crm;
        this.custoConsulta = custoConsulta;
    }

    public String getEspecialidade(){
        return this.especialidade;
    }

    public String getCrm(){
        return this.crm;
    }

    public int getCustoConsulta(){
        return this.custoConsulta;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }

    public void setCustoConsulta(int custoConsulta){
        this.custoConsulta = custoConsulta;
    }

    @Override
    public void printInformacoes(){
        System.out.println("----------------------");
        System.out.println("nome:"+ this.getNome());
        System.out.println("idade:"+ this.getIdade());
        System.out.println("telefone:"+ this.getTelefone());
        System.out.println("CRM: "+ this.crm);
        System.out.println("Especialidade: "+ this.especialidade);
        System.out.println("Custo da consulta: "+ this.custoConsulta +" reais");
        System.out.println("----------------------");
    }
}

