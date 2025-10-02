package Menus;

import Servicos.PacienteServicos;
import java.util.Scanner;

public class MenuPaciente {
    private PacienteServicos pacienteServicos;

    public MenuPaciente() {
        this.pacienteServicos = new PacienteServicos();
    }
    public MenuPaciente(PacienteServicos pacienteServicos){
        this.pacienteServicos = pacienteServicos;
    }

    

    public void exibirMenuPaciente(Scanner sc){
        System.out.println("-----Menu Paciente------");
        System.out.println("1. Exibir Paciente");
        System.out.println("2. Agendar Consulta");
        System.out.println("3. Alterar Consulta");
        System.out.println("4. Historico de Consultas");
        System.out.println("5. Quarto da internação");
        System.out.println("6. Historico de Internações");
        System.out.println(". Adicionar Plano de Saude");
        System.out.println(". Agendar Consulta para dependentes");

        int escolha = 0; 
        escolha = sc.nextInt();
        sc.nextLine();
       
        switch (escolha){
            case 1:
                this.exibirPaciente(sc);
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
        }
    }

    public void exibirPaciente(Scanner sc){
        System.out.println();
        System.out.println("Digite o CPF do paciente desejado:");
        String cpf = sc.nextLine();
        System.out.println(cpf);
        if(!pacienteServicos.cpfCadastrado(cpf)){
            System.out.println("\nCPF não cadastrado.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
            this.exibirMenuPaciente(sc);
        }
        else{
            System.out.println("\n"+pacienteServicos.getPaciente(cpf).toString());
            System.out.println();
            System.out.println("Pressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
            this.exibirMenuPaciente(sc);
        }
    }
}
