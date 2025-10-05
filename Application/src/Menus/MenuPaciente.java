package Menus;

import Entidades.*;
import static Menus.Cores.delay;
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
        
        int escolha = -1; 
        while(escolha != 0){
            exibirMenuPaciente();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    exibirPaciente(sc);
                    break;
                case 2:
                    agendarConsulta(sc);
                    break;
                case 3:
                    alterarConsulta(sc);
                    break;
                case 4:
                    historicoConsultas(sc);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Escolha uma alternativa valida");
            }

        }
    }

    public void exibirMenuPaciente(){
        System.out.println();
        System.out.println("-----Menu Paciente------");
        System.out.println("1. Exibir Paciente");//
        System.out.println("2. Agendar Consulta");//
        System.out.println("3. Alterar Consulta");//
        System.out.println("4. Historico de Consultas");
        System.out.println("5. Quarto da internação");
        System.out.println("6. Historico de Internações");
        System.out.println(". Adicionar Plano de Saude");
        System.out.println(". Agendar Consulta para dependentes");

    }

    public void exibirPaciente(Scanner sc){
        System.out.println();
        System.out.println("Digite o CPF do paciente desejado:");
        String cpf = sc.nextLine();
        System.out.println(cpf);
        if(pacienteServicos.cpfCadastrado(cpf)==false){
            System.out.println("\nCPF não cadastrado.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
            
        }
        else if(pacienteServicos.getPaciente(cpf).getNome().equals("")){
            System.out.println("\n"+pacienteServicos.getPacienteEspecial(cpf).toString());
            System.out.println();
            System.out.println("Pressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            } 
            exibirMenuPaciente();
            return;
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
            exibirMenuPaciente();
            return;
        }
    }

    public void agendarConsulta(Scanner sc){
        int id;
        Paciente paciente = new Paciente();
        Medico medico;
        String local="";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        LocalDateTime dataHora = LocalDateTime.now();
        int correto = 2;
        String cpf = "";
        String crm = "";

        while(correto == 2){
            System.out.println("\nAgendar consultas selecionado\n");
            System.out.println("Digite seu CPF: \n");
            cpf = sc.nextLine();
            System.out.println("\nDigite o CRM do medico desejado: ");
            crm = sc.nextLine();
            System.out.println("\nDigite o local desejado para a consulta: ");
            local = sc.nextLine();
            System.out.println("\nDigite a data e hora desejada para a consulta (Siga o formato 'dd/MM/yyyy-HH:mm'): ");
            String dataHoraFormatada = sc.nextLine();
            dataHora = LocalDateTime.parse(dataHoraFormatada,formatter);
            
            if(paciente.getNome().equals(pacienteServicos.getPaciente(cpf).getNome())){
                paciente = pacienteServicos.getPacienteEspecial(cpf);
            }else paciente = pacienteServicos.getPaciente(cpf);
            System.out.println("\nAs informações estão corretas?");
            System.out.printf("\nNome do paciente: %s\nNome do medico: %s\nLocal da consulta: %s\nData e hora: %s\n", paciente.getNome(),medicoServicos.getMedico(crm).getNome(),local,dataHoraFormatada);        
            System.out.println("\n1.Sim 2.Não 0.Cancelar");
            correto = sc.nextInt();
            sc.nextLine();
        }
        if(correto == 0){
            exibirMenuPaciente();
            return;
        }
        double precodaConsulta;
        id = consultaServicos.getConsultas().size()+1;
        
        medico = medicoServicos.getMedico(crm);
        int retorno = consultaServicos.cadastrarConsulta(id, paciente, medico, local, 0, dataHora);
        precodaConsulta = consultaServicos.getConsulta(id).valorConsulta();

        switch (retorno) {
            //0 se deu tudo certo , 1 se o medico possui consulta marcada para esse horario , 2 se o local ja esta agendado para esse horario, 3 se ambos estao indisponiveis e 4 se medico nao atende nesse horario
    
            case 0:
                System.out.println("Consulta de id: "+id+ "cadastrada!");
                System.out.println("O valor a pagar é de: "+precodaConsulta);
                break;
            case 1:
                System.out.println("O medico esta indisponivel neste horario");
                break;
            case 2:
                System.out.println("O local esta indisponivel neste horario");
                break;
            case 3:
                System.out.println("O medico e o local estão indisponiveis neste horario");
                break;
            case 4:
                System.out.println("O medico não atende neste horario");
                break;
        
            default:
                System.out.println("Erro ao cadastrar consulta");
                break;
        }
    }

    public void alterarConsulta(Scanner sc){
        System.out.println("\nAlterar consulta selecionado...");
        System.out.println("\nDigite o id da consulta que deseja alterar:\n");
        int opcao;
        int id = sc.nextInt();
        sc.nextLine();
        Consulta consultaAlterada = consultaServicos.getConsulta(id);
        if(consultaAlterada.getMedico().getNome().equals("")){
            System.out.println("\n Esse id não existe!\n");
            alterarConsulta(sc);
        }
        System.out.println();
        System.out.println(consultaAlterada.getIdConsulta());
        System.out.println(consultaAlterada.getMedico().getNome());
        System.out.println(consultaAlterada.getPaciente().getNome());
        System.out.println(consultaAlterada.getLocal());
        System.out.println(consultaAlterada.getStatus());
        System.out.println(consultaAlterada.getDataHoraFormatada());
        System.out.println(consultaAlterada.getDiagnostico());
        System.out.println();
        delay(1);
        System.out.println("Deseja cancelar a Consulta?\n");
        System.out.println("1.Sim 2.Não\n");
        while(true){
            opcao = sc.nextInt();
            sc.nextLine();
            if(opcao == 1){
                consultaAlterada.setStatus(2);
                System.out.println("\nConsulta cancelada!\n");
                delay(1);
                break;
            }
            else if(opcao == 2){
                System.out.println("\nConsulta confirmada!\n");
                delay(1);
                break;
            }
        }
    }

    public void historicoConsultas(Scanner sc){
        int opcao;
        System.out.println("Acessando Historico de consultas...");
        delay(1);
        System.out.println("\nDigite seu CPF: ");
        String cpf = sc.nextLine();

        if(pacienteServicos.cpfCadastrado(cpf) == false){
            System.out.println("\nEsse CPF não está cadastrado!\n");
            delay(1);
            exibirMenuPaciente();
            return;
        }
        if(pacienteServicos.getPaciente(cpf).getNome().equals("")){
            PacienteEspecial paciente = pacienteServicos.getPacienteEspecial(cpf);
            for(Consulta consulta : paciente.getConsultas()){
                delay(1);
                System.out.println("\nid da consulta: "+consulta.getIdConsulta());
                System.out.println("Medico: "+consulta.getMedico().getNome());
                System.out.println("Paciente: "+consulta.getPaciente().getNome());
                System.out.println("Local: "+consulta.getLocal());
                System.out.println("Status: "+consulta.getStatusString());
                System.out.println("Data e hora: "+consulta.getDataHoraFormatada());
                if(consulta.getStatus()==1)System.out.println("Diagnostico medico: "+consulta.getDiagnostico());
                System.out.println("Valor a pagar: "+consulta.valorConsulta());
                
                System.out.println("\nPrecione 1 para continuar");
                System.out.println("Precione 0 para sair");
                opcao = sc.nextInt();
                sc.nextLine();
                if(opcao == 0){
                    exibirMenuPaciente();
                return;
                }
            }
            System.out.println("Fim do historico, voltando ao menu...");
            delay(1);
        }
        else {
            Paciente paciente = pacienteServicos.getPaciente(cpf);
            for(Consulta consulta : paciente.getConsultas()){
                delay(1);
                System.out.println("\nid da consulta: "+consulta.getIdConsulta());
                System.out.println("Medico: "+consulta.getMedico().getNome());
                System.out.println("Paciente: "+consulta.getPaciente().getNome());
                System.out.println("Local: "+consulta.getLocal());
                System.out.println("Status: "+consulta.getStatusString());
                System.out.println("Data e hora: "+consulta.getDataHoraFormatada());
                if(consulta.getStatus()==1)System.out.println("Diagnostico medico: "+consulta.getDiagnostico());
                System.out.println("Valor a pagar: "+consulta.valorConsulta());
                
                System.out.println("\nPrecione 1 para continuar");
                System.out.println("Precione 0 para sair");
                opcao = sc.nextInt();
                sc.nextLine();
                if(opcao == 0){
                    exibirMenuPaciente();
                return;
                }
            }
            System.out.println("Fim do historico, voltando ao menu...");
            delay(1);
        
        }
    }
}
