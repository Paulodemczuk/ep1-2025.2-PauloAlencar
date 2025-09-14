package Entidades;

import java.util.ArrayList;

public class Medico extends Pessoa{
    private String especialidade;
    private String crm;
    private int custoConsulta;
    private ArrayList<ArrayList<String>> agenda;

    public Medico(){
        super();
        this.especialidade = "";
        this.crm = "";
        this.custoConsulta = 0;
        this.agenda = new ArrayList<>(); 
        ArrayList<String> diasSemana = new ArrayList<>();
        diasSemana.add("Segunda"); // Sempre 0
        diasSemana.add("Terça");// Sempre 1
        diasSemana.add("Quarta");// Sempre 2
        diasSemana.add("Quinta");// Sempre 3
        diasSemana.add("Sexta");// Sempre 4
        diasSemana.add("Sabado");// Sempre 5
        diasSemana.add("Domingo");// Sempre 6
        
        for (int i= 0; i<diasSemana.size();i++){
            String aux = diasSemana.get(i);
            ArrayList<String> colunaDia = new ArrayList<>();
            colunaDia.add(aux);
            this.agenda.add(colunaDia);
        }
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

    public void adicionarHorario(int dia, String horario){
        dia--;
        agenda.get(dia).add(horario);
    }

    public void exibirAgenda(){
        for(int i = 0;i<7;i++){
            String dia = agenda.get(i).get(0);
            System.out.print(dia + ": ");
            
            if(agenda.get(i).size() > 1){
                for (int i2 = 1;i2< agenda.get(i).size(); i2++){
                    String horario = agenda.get(i).get(i2);
                    System.out.print(horario+ " ");
                }
                System.out.println();
            }
            else System.out.println("sem vagas");
        }
    }

    public boolean verificarAtendimento(int dia, String horario){
        boolean atende;
        atende = agenda.get(dia-1).contains(horario);
        return atende;
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

