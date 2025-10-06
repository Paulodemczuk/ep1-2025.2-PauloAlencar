package Menus;

import Servicos.*;
import java.util.Scanner;

public class MenuCadastro {

    private final PacienteServicos pacienteServicos;
    private final ConsultaServicos consultaServicos;
    private final MedicoServicos medicoServicos;
    private final InternacaoServicos internacaoServicos;

    public MenuCadastro(HospitalServicos hospitalServicos) {
        this.pacienteServicos = hospitalServicos.getPacienteServicos();
        this.consultaServicos = hospitalServicos.getConsultaServicos();
        this.medicoServicos = hospitalServicos.getMedicoServicos();
        this.internacaoServicos = hospitalServicos.getInternacaoServicos();
    }

    public void acessarMenuCadastro(Scanner sc){
        
        int escolha = -1; 
        while(escolha != 0){
            exibirMenuCadastro();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Escolha uma alternativa valida");
            }

        }
    }

    public void exibirMenuCadastro(){
        System.out.println("----- Menu Cadastro ------");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Cadastrar Médico");
        System.out.println("3. Cadastrar Plano de Saude");
        System.out.println(". ");
        System.out.println(". ");
        System.out.println("\n0.Voltar");            
    }
}
