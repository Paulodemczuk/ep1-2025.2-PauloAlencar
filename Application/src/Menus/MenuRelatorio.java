package Menus;

import Entidades.*;
import static Menus.Cores.delay;
import Servicos.ConsultaServicos;
import Servicos.HospitalServicos;
import Servicos.InternacaoServicos;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import Servicos.PlanoServicos;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MenuRelatorio {

    private final PacienteServicos pacienteServicos;
    private final ConsultaServicos consultaServicos;
    private final MedicoServicos medicoServicos;
    private final InternacaoServicos internacaoServicos;
    private final PlanoServicos planoServicos;

    public MenuRelatorio(HospitalServicos hospitalServicos) {
        this.pacienteServicos = hospitalServicos.getPacienteServicos();
        this.consultaServicos = hospitalServicos.getConsultaServicos();
        this.medicoServicos = hospitalServicos.getMedicoServicos();
        this.internacaoServicos = hospitalServicos.getInternacaoServicos();
        this.planoServicos = hospitalServicos.getPlanoServicos();
    }

    



    public void acessarMenuRelatorio(Scanner sc){
        
        int escolha = -1; 
        while(escolha != 0){
            exibirMenuRelatorio();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    pacientesCadastrados(sc);
                    break;
                case 2:
                    medicosCadastrados(sc);
                    break;
                case 3:
                    consultasCadastradas(sc);
                    break;
                case 4:
                    pacientesInternados(sc);
                    break;
                case 5:
                    
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Escolha uma alternativa valida");
            }

        }
    }

    public void exibirMenuRelatorio(){
        System.out.println();
        System.out.println("----- Menu Relatorios ------");
        System.out.println("1. Pacientes cadastrados");
        System.out.println("2. Médicos cadastrados");
        System.out.println("3. Consultas futuras e passadas");
        System.out.println("4. Pacientes internados");

        System.out.println("\n0.Voltar"); 
    }

    public void pacientesCadastrados(Scanner sc){
        System.out.println("\nExibindo pacientes cadastrados...");
        delay(1);
        for(Paciente paciente : pacienteServicos.getPacientes()){
            System.out.println(paciente.toString());
            delay(1);
        }
        for(PacienteEspecial paciente : pacienteServicos.getPacientesEspeciais()){
            System.out.println(paciente.toString());
            delay(1);
        }
        System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
    }

    public void medicosCadastrados(Scanner sc){
        System.out.println("\nExibindo medicos cadastrados...");
        delay(1);
        for(Medico medico : medicoServicos.getMedicos()){
            medico.printInformacoes();
            delay(1);
        }
        System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
    }

    public void consultasCadastradas(Scanner sc){
        System.out.println("\nExibindo consultas cadastradas");
        delay(1);
        for(Consulta consulta : consultaServicos.getConsultas()){
            System.out.println(consulta.toString());
            delay(1);
            System.out.println();
        }
        System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
    }

    public void pacientesInternados(Scanner sc){
        System.out.println("\nExibindo pacientes internados...");
        delay(1);
        for(Internacao internacao : internacaoServicos.getInternacoes()){
            if(internacao.getDuracaoInternacao()<0){
                System.out.println();
                System.out.printf("Paciente: "+internacao.getPaciente().getNome());
                System.out.printf(" Data de entrada: "+internacao.getDataEntradaFormatada());
                System.out.printf(" Quarto: "+internacao.getQuarto());
                System.out.printf(" Dias internado: "+ ChronoUnit.DAYS.between(internacao.getDataEntrada(), LocalDate.now()));
                System.out.printf(" id da internação: "+internacao.getIdInternacao());
                System.out.println();
                delay(1);
            }
        }
        System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
    }
}
