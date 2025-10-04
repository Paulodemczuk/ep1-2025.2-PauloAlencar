package Servicos;

import Entidades.PlanodeSaude;
import java.util.ArrayList;

public class PlanoServicos {
    ArrayList<PlanodeSaude> planosdeSaude;

    public PlanoServicos(){
        this.planosdeSaude = new ArrayList<>();
    }
    public PlanoServicos(ArrayList<PlanodeSaude> planosdeSaude){
        this.planosdeSaude = planosdeSaude;
    }

    public boolean cadastrarPlano(String nome, double valorDesconto, ArrayList<String> especialidades){
        for(PlanodeSaude planodeSaude : planosdeSaude){
            if(planodeSaude.getNome().equals(nome)){
                System.out.println("nome ja cadastrado");
                return false;
            }
        }
        PlanodeSaude planodeSaude = new PlanodeSaude(nome, valorDesconto, especialidades);
        this.planosdeSaude.add(planodeSaude);
        return true;
    }

    public boolean cadastrarPlano(PlanodeSaude planodeSaudeNovo){
        for(PlanodeSaude planodeSaude : planosdeSaude){
            if(planodeSaude.getNome().equals(planodeSaudeNovo.getNome())){
                System.out.println("nome ja cadastrado");
                return false;
            }
        }
        this.planosdeSaude.add(planodeSaudeNovo);
        return true;
    }



    public ArrayList<PlanodeSaude> getPlanosdeSaude() {
        return planosdeSaude;
    }

    public void setPlanosdeSaude(ArrayList<PlanodeSaude> planosdeSaude) {
        this.planosdeSaude = planosdeSaude;
    }
    
    public void printPlanosdeSaude(){
        for(PlanodeSaude planodeSaude : planosdeSaude){
            System.out.println();
            System.out.println(planodeSaude.getNome());
            System.out.println(planodeSaude.getValorDesconto());
            for(String especialidade : planodeSaude.getEspecialidades()){
                System.out.printf(especialidade + " ");
            }
            System.out.println();
        }
    }
}
