package Menus;

import Entidades.Medico;
import Entidades.Paciente;
import Servicos.ConsultaServicos;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuPaciente {
    private final PacienteServicos pacienteServicos;
    private final ConsultaServicos consultaServicos;
    private final MedicoServicos medicoServicos;

    public MenuPaciente() {
        this.pacienteServicos = new PacienteServicos();
        this.consultaServicos = new ConsultaServicos();
        this.medicoServicos = new MedicoServicos();
    }
    public MenuPaciente(PacienteServicos pacienteServicos,ConsultaServicos consultaServicos,MedicoServicos medicoServicos){
        this.pacienteServicos = pacienteServicos;
        this.consultaServicos = consultaServicos;
        this.medicoServicos = medicoServicos;
    }

    

    public void acessarMenuPaciente(Scanner sc){
        System.out.println("-----Menu Paciente------");
        System.out.println("1. Exibir Paciente");//
        System.out.println("2. Agendar Consulta");
        System.out.println("3. Alterar Consulta");
        System.out.println("4. Historico de Consultas");
        System.out.println("5. Quarto da internação");
        System.out.println("6. Historico de Internações");
        System.out.println(". Adicionar Plano de Saude");
        System.out.println(". Agendar Consulta para dependentes");

        int escolha = -1; 
        while(escolha != 0){
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    exibirPaciente(sc);
                    break;
                case 2:
                    agendarConsulta(sc);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Escolha uma alternativa valida");
            }

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
            this.acessarMenuPaciente(sc);
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
            this.acessarMenuPaciente(sc);
        }
    }

    public void agendarConsulta(Scanner sc){
        int id;
        Paciente paciente;
        Medico medico;
        String local;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        LocalDateTime dataHora;

        System.out.println("\nAgendar consultas selecionado\n");
        System.out.println("Digite seu CPF: \n");
        String cpf = sc.nextLine();
        System.out.println("\nDigite o CRM do medico desejado: ");
        String crm = sc.nextLine();
        System.out.println("\nDigite o local desejado para a consulta: ");
        local = sc.nextLine();
        System.out.println("\nDigite a data e hora desejada para a consulta (Siga o formato 'dd/MM/yyyy-HH:mm'): ");
        String dataHoraFormatada = sc.nextLine();
        dataHora = LocalDateTime.parse(dataHoraFormatada,formatter);

        System.out.println("As informações estão corretas?");
        System.out.printf("\nNome do paciente: %s\nNome do medico: %s\nLocal da consulta: %s\nData e hora: %s\n", pacienteServicos.getPaciente(cpf).getNome(),medicoServicos.getMedico(crm).getNome(),local,dataHoraFormatada);        





        //int retorno = consultaServicos.cadastrarConsulta(id, paciente, medico, local, status, dataHora);

        double precodaConsulta;
    }
}
