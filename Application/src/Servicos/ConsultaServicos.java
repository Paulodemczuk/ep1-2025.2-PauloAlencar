package Servicos;

import Entidades.Consulta;
import Entidades.Medico;
import Entidades.Paciente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsultaServicos {
    private ArrayList<Consulta> consultas;

    public ConsultaServicos(){
        this.consultas = new ArrayList<>();
    }
    public ConsultaServicos(ArrayList<Consulta> consultas){
        this.consultas = consultas;
    }

    public int cadastrarConsulta(Paciente paciente, Medico medico, String local, int status, LocalDateTime dataHora){
        int dia = dataHora.getDayOfWeek().getValue() - 1;
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("HH:mm");
        String horario = dataHora.format(formatacao);

        if(medico.verificarAtendimento(dia, horario) == false){
            System.out.println("o medico nao atende nesse horario");
            return 4;
        }
        int retorno = 0;

        for(Consulta consulta : consultas){
            if((consulta.getMedico().getCrm().equals(medico.getCrm())) && (consulta.getDataHora()== dataHora)){
                System.out.println("Medico ja possui consulta marcada para esse horario");
                retorno = 1;
            }
            if((consulta.getLocal().equals(local)) && (consulta.getDataHora() == dataHora)){
                System.out.println("Esse local ja possui uma consulta agendada para este horario");
                if(retorno == 1) return 3;
                else retorno = 2;
            }
            if(retorno == 1) return 1;
        }
        
        Consulta consultaAgendada = new Consulta(paciente, medico, local, status, dataHora," ");
        this.consultas.add(consultaAgendada);            
        return retorno; //0 se deu tudo certo , 1 se o medico possui consulta marcada para esse horario , 2 se o local ja esta agendado para esse horario, 3 se ambos estao indisponiveis e 4 se medico nao atende nesse horario
    }

    public int cadastrarConsulta(Consulta consulta){
        int dia = consulta.getDataHora().getDayOfWeek().getValue() - 1;
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("HH:mm");
        String horario = consulta.getDataHora().format(formatacao);
        
        if(consulta.getMedico().verificarAtendimento(dia, horario) == false){
            System.out.println("o medico nao atende nesse horario");
            return 4;
        }
        int retorno = 0;

        for(Consulta consultaCadastrada : consultas){
            if((consultaCadastrada.getMedico().getCrm().equals(consulta.getMedico().getCrm())) && (consultaCadastrada.getDataHora()== consulta.getDataHora())){
                System.out.println("Medico ja possui consulta marcada para esse horario");
                retorno = 1;
            }
            if((consultaCadastrada.getLocal().equals(consulta.getLocal())) && (consultaCadastrada.getDataHora() == consulta.getDataHora())){
                System.out.println("Esse local ja possui uma consulta agendada para este horario");
                if(retorno == 1) return 3;
                else retorno = 2;
            }
            if(retorno == 1) return 1;
        }
        
        this.consultas.add(consulta);            
        return retorno;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void printConsultas(){
        for(Consulta consulta : consultas){
            System.out.println(consulta.getMedico().getNome());
            System.out.println(consulta.getPaciente().getNome());
            System.out.println(consulta.getLocal());
            System.out.println(consulta.getStatus());
            System.out.println(consulta.getDataHoraFormatada());
            System.out.println(consulta.getDiagnostico());
        }
    }

    public void addConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }
}
