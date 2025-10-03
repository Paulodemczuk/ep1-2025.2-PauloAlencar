package Entidades;

public class PacienteEspecial extends Paciente{
    private PlanodeSaude plano;

    public PacienteEspecial(){
        super();
        this.plano = null;
    }

    public PacienteEspecial(PlanodeSaude plano, String nome, int idade, String cpf) {
        super(nome, idade, cpf);
        this.plano = plano;
    }

    public PlanodeSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanodeSaude plano) {
        this.plano = plano;
    }

    @Override
    public String toString(){
        return "---------------------\nNome: "+ this.getNome() +"\nIdade: "+ this.getIdade() + "\nCPF: " + this.getCpf() + "\nPlano: "+ this.getPlano().getNome() + "\n---------------------\n";
    }
}
