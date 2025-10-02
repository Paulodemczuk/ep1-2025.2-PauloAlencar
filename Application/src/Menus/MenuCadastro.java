package Menus;

import Servicos.PacienteServicos;
import java.util.Scanner;

public class MenuCadastro {
    private PacienteServicos pacienteServicos;

    public MenuCadastro() {
        this.pacienteServicos = new PacienteServicos();
    }

    public MenuCadastro(PacienteServicos pacienteServicos){
        this.pacienteServicos = pacienteServicos;
    }

    public void exibirMenuCadastro(Scanner sc){
            System.out.println("----- Menu Cadastro ------");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Cadastrar Plano de Saude");
            System.out.println(". ");
            System.out.println(". ");
        
        int escolha = 0; 
        escolha = sc.nextInt();
        sc.nextLine();
       
        switch (escolha){
            case 1:
                
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
        }
    }

    public void cadastrarPaciente(Scanner sc){
        
    }
}
