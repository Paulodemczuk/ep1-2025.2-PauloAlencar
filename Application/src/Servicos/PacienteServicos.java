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
        if(!cadastrou){
            Paciente novoPaciente = new Paciente(nome, idade, telefone, cpf);
            this.pacientes.add(novoPaciente);
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

    public Paciente getPaciente(String cpf){
        Paciente retorno = new Paciente();
        for(Paciente paciente: pacientes){
            if(paciente.getCpf().equals(cpf)){
                retorno = paciente;
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
}
