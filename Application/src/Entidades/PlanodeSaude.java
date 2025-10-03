package Entidades;

import java.util.ArrayList;

public class PlanodeSaude {
    private String nome;
    private ArrayList<String> especialidades;
    private double valorDesconto;

    public PlanodeSaude(){
        this.nome = "";
        this.especialidades = new ArrayList<>();
        this.valorDesconto = 1;
    }

    public PlanodeSaude(String nome, double valorDesconto){
        this.nome = nome;
        this.especialidades = new ArrayList<>();
        this.valorDesconto = valorDesconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<String> especialidades) {
        this.especialidades = especialidades;
    }

    public double getValorDesconto() {
        return valorDesconto; 
    }

    public double getValorDesconto(String especialidadeDesconto) {
        for(String especialidade : especialidades){
            if(especialidade.equals(especialidadeDesconto)){
                valorDesconto = valorDesconto - 0.1;
                break;
            }
        }
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
