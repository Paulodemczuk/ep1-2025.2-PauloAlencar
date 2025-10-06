package Entidades;

import java.util.ArrayList;

public class Medico extends Pessoa{
    private String especialidade;
    private String crm;
    private double custoConsulta;
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

    public Medico(String nome, int idade, String especialidade, String crm, double custoConsulta){
        super(nome, idade);
        this.especialidade = especialidade;
        this.crm = crm;
        this.custoConsulta = custoConsulta;
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

    public String getEspecialidade(){
        return this.especialidade;
    }

    public String getCrm(){
        return this.crm;
    }

    public double getCustoConsulta(){
        return this.custoConsulta;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }

    public void setCustoConsulta(double custoConsulta){
        this.custoConsulta = custoConsulta;
    }

    public void adicionarHorario(int dia, String horario){
        agenda.get(dia).add(horario);
    }

    public void adicionarHorarios(int dia, String horarios){
        String[] horario = horarios.split(" ");
        int quantidadeHorarios = horario.length;
        for(int nr1 = 0; nr1 < quantidadeHorarios; nr1++){
            agenda.get(dia).add(horario[nr1]);
        }
    }

    public void exibirAgenda(){
        System.out.println();
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
        public String getHorarios(int dia){
            String horarios = "";
            if(agenda.get(dia).size()==1){
                return " ";
            }
            horarios += agenda.get(dia).get(1);
            for(int nr1 = 2; nr1 < agenda.get(dia).size();nr1++){
                horarios +=  " " + agenda.get(dia).get(nr1);
            }
            return horarios;
        }

    public boolean verificarAtendimento(int dia, String horario){
        boolean atende;
        atende = agenda.get(dia).contains(horario);
        return atende;
    }

    @Override
    public void printInformacoes(){
        System.out.println();
        System.out.println("----------------------");
        System.out.println("nome:"+ this.getNome());
        System.out.println("idade:"+ this.getIdade());
        System.out.println("CRM: "+ this.crm);
        System.out.println("Especialidade: "+ this.especialidade);
        System.out.println("Custo da consulta: "+ this.custoConsulta +" reais");
        System.out.println("----------------------");
    }
}

