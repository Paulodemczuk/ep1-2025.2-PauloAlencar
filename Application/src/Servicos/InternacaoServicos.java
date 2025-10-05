package Servicos;

import Entidades.Internacao;
import Entidades.Medico;
import Entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;

public class InternacaoServicos {
    ArrayList<Internacao> internacoes;

    public InternacaoServicos(){
        this.internacoes = new ArrayList<>();
    }
    public InternacaoServicos(ArrayList<Internacao> internacoes){
        this.internacoes = internacoes;
    }

    public boolean cadastrarInternacao(int id, Paciente paciente, Medico medico, LocalDate dataEntrada, LocalDate dataSaida, int quarto, double custoInternacao){
        for(Internacao internacao : internacoes){
            if(internacao.getQuarto() == quarto){
                System.out.println("quato ocupado");
                return false;
            }
        }
        Internacao internacao = new Internacao(id, paciente, medico, dataEntrada, dataSaida, quarto, custoInternacao);
        this.internacoes.add(internacao);
        return true;
    }

    public boolean cadastrarInternacao(Internacao novaInternacao){
        for(Internacao internacao : internacoes){
            if(internacao.getQuarto() == novaInternacao.getQuarto()){
                System.out.println("quato ocupado");
                return false;
            }
        }
        this.internacoes.add(novaInternacao);
        return true;
    }


    public ArrayList<Internacao> getInternacoes() {
        return internacoes;
    }

    public void setInternacoes(ArrayList<Internacao> internacoes) {
        this.internacoes = internacoes;
    }

    public void printInternacoes(){
        System.out.println();
        for(Internacao internacao : internacoes){
            System.out.println(internacao.getIdInternacao());
            System.out.println(internacao.getMedico().getNome());
            System.out.println(internacao.getPaciente().getNome());
            System.out.println(internacao.getQuarto());
            System.out.println(internacao.getDataEntradaFormatada());
            System.out.println(internacao.getDataSaidaFormatada());
            System.out.println(internacao.getDuracaoInternacao());
            System.out.println(internacao.getCustoInternacao());
            System.out.println();
        }
    }

    public Internacao getInternacao(int id){
        Internacao retorno = new Internacao();
        for(Internacao internacao: internacoes){
            if(internacao.getIdInternacao() == id){
                retorno = internacao;
                break;
            }
        }
        return retorno;
    
    }

}
