package Servicos;

import Entidades.Paciente;
import java.util.ArrayList;

public class PacienteServicos {
    private ArrayList<Paciente> pacientes;

    public PacienteServicos() {
        this.pacientes = new ArrayList<>();
    }

    public boolean cadastrarPaciente(String nome, int idade, String telefone, String cpf){
        boolean cadastrou = cpfCadastrado(cpf);
        if(cadastrou){
            Paciente novoPaciente = new Paciente(nome, idade, telefone, cpf);
            pacientes.add(novoPaciente);
            cadastrou = true;
        }
        return cadastrou;
    }

    public boolean cpfCadastrado(String cpf){
        boolean existe = false;
        for(Paciente paciente : pacientes){
            if(paciente.getCpf().equals(cpf)){
                existe = true;
                break;
            }
        
        }
        return existe;
    }
    
}
