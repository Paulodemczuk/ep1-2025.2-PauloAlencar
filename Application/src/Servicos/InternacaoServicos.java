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

    public boolean cadastrarInternacao(Paciente paciente, Medico medico, LocalDate dataEntrada, LocalDate dataSaida, int quarto, double custoInternacao){
        for(Internacao internacao : internacoes){
            if(internacao.getQuarto() == quarto){
                System.out.println("quato ocupado");
                return false;
            }
        }
        Internacao internacao = new Internacao(paciente, medico, dataEntrada, dataSaida, quarto, custoInternacao);
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


}
