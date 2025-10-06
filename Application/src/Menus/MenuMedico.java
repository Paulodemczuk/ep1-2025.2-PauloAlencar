package Menus;

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
        System.out.println("2. Finalizar Consulta");
        System.out.println("3. Cancelar Consulta");
        System.out.println("4. Internar Paciente");
        System.out.println("5. Cancelar Internação");
        System.out.println("6. Alterar Agenda de Horarios");
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
}
