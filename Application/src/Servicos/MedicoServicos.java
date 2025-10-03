package Servicos;

import java.util.ArrayList;

import Entidades.Medico;

public class MedicoServicos {
    private ArrayList<Medico> medicos;

    public MedicoServicos() {
        this.medicos = new ArrayList<>();
    }
    public MedicoServicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public boolean cadastrarMedico(String nome, int idade, String especialidade, String crm, int custoConsulta){
        boolean cadastrou = crmCadastrado(crm);
        if(!cadastrou){
            Medico novomedico = new Medico(nome, idade, especialidade, crm, custoConsulta);
            this.medicos.add(novomedico);
            cadastrou = true;
        }
        return cadastrou;
    }

    public boolean crmCadastrado(String crm){
        boolean existe = false;
        for(Medico medico : medicos){
            if(medico.getCrm().equals(crm)){
                return existe = true;
            }
        }
        return existe;
    }

    public Medico getMedico(String crm){
        Medico retorno = new Medico();
        for(Medico medico: medicos){
            if(medico.getCrm().equals(crm)){
                retorno = medico;
                break;
            }
        }
        return retorno;
    }

    public boolean excluirMedico(String crm){
        boolean removeu = crmCadastrado(crm);
        if(removeu){
            this.medicos.remove(getMedico(crm));
            removeu = true;              
        }
        return removeu;
    }

    public boolean editarMedico(String crm, String novoNome){
        boolean editou = crmCadastrado(crm);
        if(editou){
            getMedico(crm).setNome(novoNome);
        }
        return editou;
    }

    public boolean editarMedico(String crm, int novaIdade){
        boolean editou = crmCadastrado(crm);
        if(editou){
            getMedico(crm).setIdade(novaIdade);
        }
        return editou;
    }

    public void addMedico(Medico medico){
        this.medicos.add(medico);
    }

    public boolean internarPaciente(){
        
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public void printMedicos(){
        for(Medico medico : medicos){
            System.out.println(medico.getCrm());
        }
    }
}
