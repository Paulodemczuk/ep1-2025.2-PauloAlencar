package Servicos;

import Entidades.Paciente;
import Entidades.PacienteEspecial;
import Entidades.PlanodeSaude;
import java.util.ArrayList;

public class PacienteServicos {
    private ArrayList<Paciente> pacientes;
    private ArrayList<PacienteEspecial> pacientesEspeciais;

    public PacienteServicos() {
        this.pacientes = new ArrayList<>();
    }
    public PacienteServicos(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public boolean cadastrarPaciente(String nome, int idade, String cpf){
        boolean cadastrou = cpfCadastrado(cpf);
        if(!cadastrou){
            Paciente novoPaciente = new Paciente(nome, idade, cpf);
            this.pacientes.add(novoPaciente);
            cadastrou = true;
        }
        return cadastrou;
    }

    public boolean cadastrarPacienteEspecial(String nome, int idade, String cpf,PlanodeSaude plano){
        boolean cadastrou = cpfCadastrado(cpf);
        if(!cadastrou){
            PacienteEspecial novoPacienteEspecial = new PacienteEspecial(plano, nome, idade, cpf);
            this.pacientes.add(novoPacienteEspecial);
            cadastrou = true;
        }
        return cadastrou;
    }

    public boolean cpfCadastrado(String cpf){
        boolean existe = false;
        for(Paciente paciente : pacientes){
            if(paciente.getCpf().equals(cpf)){
                return existe = true;
            }
        }
        for(PacienteEspecial pacienteEspecial: pacientesEspeciais){
            if(pacienteEspecial.getCpf().equals(cpf)){
                return existe = true;
            }
        }
        return existe;
    }

    public Paciente getPaciente(String cpf){
        Paciente retorno = new Paciente();
        for(Paciente paciente: pacientes){
            if(paciente.getCpf().equals(cpf)){
                retorno = paciente;
            }
        }
        return retorno;
    }

    public PacienteEspecial getPacienteEspecial(String cpf){
        PacienteEspecial retorno = new PacienteEspecial();
        for(PacienteEspecial pacienteEspecial: pacientesEspeciais){
            if(pacienteEspecial.getCpf().equals(cpf)){
                retorno = pacienteEspecial;
            }
        }
        return retorno;
    }

    public boolean excluirPaciente(String cpf){
        boolean removeu = cpfCadastrado(cpf);
        if(removeu){
            this.pacientes.remove(getPaciente(cpf));
            removeu = true;              
        }
        return removeu;
    }

    public boolean excluirPacienteEspecial(String cpf){
        boolean removeu = cpfCadastrado(cpf);
        if(removeu){
            this.pacientesEspeciais.remove(getPacienteEspecial(cpf));
            removeu = true;              
        }
        return removeu;
    }

    public boolean editarPaciente(String cpf, String novoNome){
        boolean editou = cpfCadastrado(cpf);
        if(editou){
            getPaciente(cpf).setNome(novoNome);
        }
        return editou;
    }

    public boolean editarPaciente(String cpf, int novaIdade){
        boolean editou = cpfCadastrado(cpf);
        if(editou){
            getPaciente(cpf).setIdade(novaIdade);
        }
        return editou;
    }

    public void addPaciente(Paciente paciente){
        this.pacientes.add(paciente);
    }

    public void addPacienteEspecial(PacienteEspecial pacienteEspecial){
        this.pacientesEspeciais.add(pacienteEspecial);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void printPacientes(){
        for(Paciente paciente : pacientes){
            System.out.println(paciente.getCpf());
        }
    }

    public void printPacientesEspeciais(){
        for(PacienteEspecial pacienteEspecial : pacientesEspeciais){
            System.out.println(pacienteEspecial.getCpf());
        }
    }

    public ArrayList<PacienteEspecial> getPacientesEspeciais() {
        return pacientesEspeciais;
    }

    public void setPacientesEspeciais(ArrayList<PacienteEspecial> pacientesEspeciais) {
        this.pacientesEspeciais = pacientesEspeciais;
    }
}
