package Menus;

import Entidades.Medico;
import Entidades.Paciente;
import static Menus.Cores.delay;
import Servicos.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                    internarPaciente(sc);
                    break;
                case 4:
                    alterarInternacao(sc);
                    break;
                case 5:
                    editarAgenda(sc);
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
        System.out.println("1. Exibir Medico");//
        System.out.println("2. Alterar Consulta");//
        System.out.println("3. Internar Paciente");//
        System.out.println("4. Alterar Internação");//
        System.out.println("5. Editar Agenda de Horarios");//
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

    public void internarPaciente(Scanner sc){
        int id;
        Paciente paciente = new Paciente();
        Medico medico;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataEntrada = LocalDate.now();
        int correto = 2;
        String cpf;
        String crm = "";
        int quarto = 0;
        double custoInternacao = 0;

        //Internacao(int idInternacao,Paciente paciente, Medico medico, LocalDate dataEntrada, = nullLocalDate dataSaida, int quarto, double custoInternacao);

        

        while(correto == 2){
            System.out.println("\nInternar paciente selecionado\n");
            System.out.println("\nDigite seu CRM: ");
            crm = sc.nextLine();
            System.out.println("Digite o CPF do paciente: \n");
            cpf = sc.nextLine();
            System.out.println("\nDigite o quarto desejado para a internação: ");
            quarto = sc.nextInt();
            sc.nextLine();
            System.out.println("\nDigite a data da internação (Siga o formato 'dd/MM/yyyy'): ");
            String dataHoraFormatada = sc.nextLine();
            dataEntrada = LocalDate.parse(dataHoraFormatada,formatter);
            if(paciente.getNome().equals(pacienteServicos.getPaciente(cpf).getNome())){
                paciente = pacienteServicos.getPacienteEspecial(cpf);
            }else paciente = pacienteServicos.getPaciente(cpf);
            System.out.println("Digite o custo da diaria de internação: ");
            custoInternacao = sc.nextDouble();
            System.out.println("\nAs informações estão corretas?");
            System.out.printf("\nNome do paciente: %s\nNome do medico: %s\nQuarto : %d\nData de entrada: %s\nCusto diaria: %.2f\n", paciente.getNome(),medicoServicos.getMedico(crm).getNome(),quarto,dataHoraFormatada,custoInternacao);        
            System.out.println("\n1.Sim 2.Não 0.Voltar");
            correto = sc.nextInt();
            sc.nextLine();
        }
        if(correto == 0){
            exibirMenuMedico();
            return;
        }
        
        id = internacaoServicos.getInternacoes().size()+1;
        
        medico = medicoServicos.getMedico(crm);
        boolean retorno = internacaoServicos.cadastrarInternacao(id, paciente, medico, dataEntrada, dataEntrada, quarto, custoInternacao);
        
        if(retorno == false){
            System.out.println("O quarto está ocupado");
            delay(1);
            
        }
        else if (retorno == true){
            System.out.println("Internação cadastrada.");
            delay(1);
        
        }
        else {
            System.out.println("Erro ao cadastrar internação");
            delay(1);
        }
    }

    public void alterarInternacao(Scanner sc){
        System.out.println("\nDigite o id da internação: \n");
        int id = sc.nextInt();
        sc.nextLine();
        if(internacaoServicos.getInternacao(id).getDuracaoInternacao() >= 0){
            System.out.println("\nEssa internação ja foi concluida.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
        }else if(internacaoServicos.getInternacao(id).getQuarto() == 0){
            System.out.println("\nEssa internação nao existe.");
            System.out.println("\nPressione 0 para voltar.");
            int voltar = 1;
            while(voltar != 0){
                voltar = sc.nextInt();
                sc.nextLine();
            }
        }
        else{
            System.out.printf("\nNome do paciente: %s\nNome do medico: %s\nQuarto : %d\nData de entrada: %s\nCusto diaria: %.2f\n", internacaoServicos.getInternacao(id).getPaciente().getNome(),internacaoServicos.getInternacao(id).getMedico().getNome(),internacaoServicos.getInternacao(id).getQuarto(),internacaoServicos.getInternacao(id).getDataEntradaFormatada(),internacaoServicos.getInternacao(id).getCustoInternacao());
            delay(1);
            System.out.println("\nDeseja concluir internação?");
            int escolha = -1; 
            delay(1);
            while(escolha != 0){
                System.out.println("1.Concluir \n2.Cancelar internação \n0.Manter internação.");
                
                escolha = sc.nextInt();
                sc.nextLine();
                switch (escolha){
                    case 1:
                        System.out.println("Digite o diagnostico: \n");
                        String dataSaida = sc.nextLine();
                        internacaoServicos.getInternacao(id).setDataSaida(dataSaida);
                        System.out.println("\nInternação concluida e data de saida adicionada.");
                        delay(1);
                        return;
                    case 2:
                        internacaoServicos.getInternacao(id).getPaciente().removerInternacao(id);
                        internacaoServicos.removerInternacao(id);
                        System.out.println("\nInternação cancelada.");
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

    public void editarAgenda(Scanner sc){
        System.out.println("\nInternar paciente selecionado\n");
        System.out.println("\nDigite seu CRM: ");
        String crm = sc.nextLine();
        System.out.println("\nSua agenda: ");
        medicoServicos.getMedico(crm).exibirAgenda();
        delay(1);
        System.out.println();
        int escolha = -1;
        int dia;
        String horario;
        while (escolha != 0) {
            System.out.println("1.Adicionar Horario 2.Remover horario 0.Voltar para o menu");
            escolha = sc.nextInt();
            sc.nextLine();
            
            switch (escolha){
                case 1:
                    System.out.println("Adicionar horario em qual dia da semana? \n");
                    System.out.println("\n1.Segunda   2.Terça   3.Quarta   4.Quinta   5.Sexta   6.Sabado   7.Domingo");
                    dia = sc.nextInt() - 1;
                    sc.nextLine();
                    System.out.println("Digite o horario desejado no formato (HH:mm): ");
                    horario = sc.nextLine();
                    medicoServicos.getMedico(crm).adicionarHorario(dia, horario);
                    System.out.println("Horario adicionado!");
                    delay(1);
                    return;


                case 2:
                    System.out.println("Remover horario em qual dia da semana? \n");
                    System.out.println("\n1.Segunda   2.Terça   3.Quarta   4.Quinta   5.Sexta   6.Sabado   7.Domingo");
                    dia = sc.nextInt() - 1;
                    sc.nextLine();
                    System.out.println("\nDigite o horario desejado no formato (HH:mm): ");
                    horario = sc.nextLine();
                    medicoServicos.getMedico(crm).removerHorario(dia, horario);
                    System.out.println("Horario removido!");
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
