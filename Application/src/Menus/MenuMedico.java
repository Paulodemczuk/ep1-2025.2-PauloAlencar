package Menus;

import static Menus.Cores.delay;
import Servicos.*;
import java.util.Scanner;

public class MenuMedico {

    private final PacienteServicos pacienteServicos;
    private final ConsultaServicos consultaServicos;
    private final MedicoServicos medicoServicos;
    private final InternacaoServicos internacaoServicos;

    public MenuMedico(HospitalServicos hospitalServicos) {
        this.pacienteServicos = hospitalServicos.getPacienteServicos();
        this.consultaServicos = hospitalServicos.getConsultaServicos();
        this.medicoServicos = hospitalServicos.getMedicoServicos();
        this.internacaoServicos = hospitalServicos.getInternacaoServicos();
    }
    
    public void acessarMenuMedico(Scanner sc){
        
        int escolha = -1; 
        while(escolha != 0){
            exibirMenuMedico();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    exibirMedico(sc);
                    break;
                case 2:
                    alterarConsulta(sc);
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Escolha uma alternativa valida");
            }

        }
    }


    static public void exibirMenuMedico(){
        System.out.println();
        System.out.println("----- Menu Medico ------");
        System.out.println("1. Exibir Medico");
        System.out.println("2. Alterar Consulta");
        System.out.println("3. Internar Paciente");
        System.out.println("4. Cancelar Internação");
        System.out.println("5. Alterar Agenda de Horarios");
        System.out.println(". ");
        System.out.println(". ");
    }

    public void exibirMedico(Scanner sc){
        System.out.println();
        System.out.println("Digite o CRM do medico desejado:");
        String crm = sc.nextLine();
        System.out.println(crm);
        if(medicoServicos.crmCadastrado(crm)==false){
            System.out.println("\nCRM não cadastrado.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
        }else{
            medicoServicos.getMedico(crm).printInformacoes();
            System.out.println();
            System.out.println("Pressione 1 para exibir a agenda.");
            System.out.println("Pressione 0 para voltar.");
            int voltar = -1;
            while(voltar != 0){
                voltar = sc.nextInt();
                if(voltar == 1)medicoServicos.getMedico(crm).exibirAgenda();
                sc.nextLine();
            } 
            exibirMenuMedico();

        }
    }    

    public void alterarConsulta(Scanner sc){
        System.out.println("\nDigite o id da consulta: \n");
        int id = sc.nextInt();
        sc.nextLine();
        if(consultaServicos.getConsulta(id).getStatus() == 1){
            System.out.println("\nEssa consutla ja foi concluida.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
        }
        else if(consultaServicos.getConsulta(id).getStatus() == 2){
            System.out.println("\nEssa consutla foi cancelada.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
        }
        else{
            System.out.printf("\nNome do paciente: %s\nNome do medico: %s\nLocal da consulta: %s\nData e hora: %s\n", consultaServicos.getConsulta(id).getPaciente().getNome(),consultaServicos.getConsulta(id).getMedico().getNome(),consultaServicos.getConsulta(id).getLocal(),consultaServicos.getConsulta(id).getDataHoraFormatada());
            delay(1);
            System.out.println("\nDeseja concluir consulta?");
            int escolha = -1; 
            delay(1);
            while(escolha != 0){
                System.out.println("1.Concluir \n2.Concluir e adicionar diagnostico \n3.Cancelar consulta \n0.Manter agendamento.");
                
                escolha = sc.nextInt();
                sc.nextLine();
                switch (escolha){
                    case 1:
                        consultaServicos.getConsulta(id).setStatus(1);
                        System.out.println("\nConsulta concluida!");
                        delay(1);
                        return;
                    case 2:
                        consultaServicos.getConsulta(id).setStatus(1);
                        System.out.println("Digite o diagnostico: \n");
                        String diagnostico = sc.nextLine();
                        consultaServicos.getConsulta(id).setDiagnostico(diagnostico);
                        System.out.println("\nConsulta concluida e diagnostico adicionado!");
                        delay(1);
                        return;
                    case 3:
                        consultaServicos.getConsulta(id).setStatus(2);
                        System.out.println("\nConsulta cancelada!");
                        delay(1);
                        return;
                    
                    case 0:
                        System.out.println("Voltando ao menu...");
                        delay(1);
                        return;
                    default:
                        System.out.println("Escolha uma alternativa valida");
                }

            }

        }
        
    }
}
