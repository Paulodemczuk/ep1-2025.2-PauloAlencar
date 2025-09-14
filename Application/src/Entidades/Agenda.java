package Entidades;

import java.util.ArrayList;

public class Agenda {
    public ArrayList<ArrayList<String>> agenda;

    public Agenda(){
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
}
