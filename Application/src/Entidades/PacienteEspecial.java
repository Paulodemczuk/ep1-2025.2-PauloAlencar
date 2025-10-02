package Entidades;

public class PacienteEspecial extends Paciente{
    private PlanodeSaude plano;

    public PacienteEspecial(){
        super();
        this.plano = null;
    }

    public PacienteEspecial(PlanodeSaude plano, String nome, int idade, String telefone, String cpf) {
        super(nome, idade, telefone, cpf);
        this.plano = plano;
    }

    public PlanodeSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanodeSaude plano) {
        this.plano = plano;
    }

}
