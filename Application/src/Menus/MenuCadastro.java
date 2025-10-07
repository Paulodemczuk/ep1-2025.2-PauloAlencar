package Menus;

import Entidades.*;
import static Menus.Cores.delay;
import Servicos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastro {

    private final PacienteServicos pacienteServicos;
    private final ConsultaServicos consultaServicos;
    private final MedicoServicos medicoServicos;
    private final InternacaoServicos internacaoServicos;
    private final PlanoServicos planoServicos;

    public MenuCadastro(HospitalServicos hospitalServicos) {
        this.pacienteServicos = hospitalServicos.getPacienteServicos();
        this.consultaServicos = hospitalServicos.getConsultaServicos();
        this.medicoServicos = hospitalServicos.getMedicoServicos();
        this.internacaoServicos = hospitalServicos.getInternacaoServicos();
        this.planoServicos = hospitalServicos.getPlanoServicos();
    }

    public void acessarMenuCadastro(Scanner sc){
        
        int escolha = -1; 
        while(escolha != 0){
            exibirMenuCadastro();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    cadastrarPaciente(sc);
                    break;
                case 2:
                    cadastrarMedico(sc);
                    break;
                case 3:
                    cadastrarPlanodeSaude(sc);
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
        System.out.println();
        System.out.println("----- Menu Cadastro ------");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Cadastrar Médico");
        System.out.println("3. Cadastrar Plano de Saude");
        System.out.println("\n0.Voltar");            
    }

    public void cadastrarPaciente(Scanner sc){
        System.out.println("Cadastrar Paciente...");
        delay(1);
        System.out.println("\nDigite o nome: ");
        String nome = sc.nextLine();
        System.out.println("\nDigite o CPF: ");
        String cpf = sc.nextLine();
        if(pacienteServicos.cpfCadastrado(cpf)==true){
            System.out.println("Esse cpf ja esta cadastrado!");
            delay(1);
            return;
        }
        System.out.println("\nDigite a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("\nPossui plano de saude?");
        System.out.println("1.Sim 2.Nao");
        int possuiPlano = sc.nextInt();
        sc.nextLine();
        if(possuiPlano==2){
            Paciente paciente = new Paciente(nome, idade, cpf);
            pacienteServicos.addPaciente(paciente);
            System.out.println("\nPaciente adicionado!");
            
        }
        else if(possuiPlano == 1){
            System.out.println("\nDigite o nome do Plano:");
            String nomePlano = sc.nextLine();
            if(planoServicos.getPlanodeSaude(nomePlano).getNome().equals("")){
                System.out.println("\nEsse plano de saude nao esta cadastrado.");
                delay(1);
                return;
            }
            PacienteEspecial pacienteEspecial = new PacienteEspecial(planoServicos.getPlanodeSaude(nomePlano), nome, idade, cpf);
            pacienteServicos.addPacienteEspecial(pacienteEspecial);
            System.out.println("\nPaciente especial cadastrado!");
            
        }
        else {
            System.out.println("\nOpção invalida!");
        }
    }

    public void cadastrarMedico(Scanner sc){
        System.out.println("Cadastrar medico...");
        delay(1);
        System.out.println("\nDigite o nome: ");
        String nome = sc.nextLine();
        System.out.println("\nDigite o CRM: ");
        String crm = sc.nextLine();
        System.out.println("\nDigite a especialidade: ");
        String especialidade = sc.nextLine();
        System.out.println("\nDigite o custo da consulta: ");
        double custoConsulta = sc.nextDouble();
        sc.nextLine();
        if(medicoServicos.crmCadastrado(crm)==true){
            System.out.println("Esse CRM ja esta cadastrado!");
            delay(1);
            return;
        }
        System.out.println("\nDigite a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        Medico medico = new Medico(nome, idade, especialidade, crm, custoConsulta);
        medicoServicos.addMedico(medico);
        System.out.println("\nMedico cadastrado!");
        delay(1);
    }
    
    public void cadastrarPlanodeSaude(Scanner sc){
        System.out.println("\nCadastrar plano de saude...");
        delay(1);
        System.out.println("\nDigite o nome do plano de saude:");
        String nomePlano = sc.nextLine();
        if(planoServicos.getPlanodeSaude(nomePlano).getNome().equals(nomePlano)){
            System.out.println("\nEsse esse nome ja esta cadastrado.");
            delay(1);
            return;
        }
        System.out.println("\nDigite o valor de desconto (Em porcentagem sem incluir '%'):");
        double valorDesconto = 1 - (sc.nextDouble()/100);
        sc.nextLine();
        ArrayList<String> especialidades = new ArrayList<>();
        System.out.println("\nDeseja incluir o beneficio de internações com duração de uma semana ou menos gratuitas?");
        System.out.println("1.Sim 2.Não");
        int opcao = sc.nextInt();
        sc.nextLine();
        if(opcao == 1){
            especialidades.add("Internacao");
        }
        System.out.println("\nDeseja incluir descontos para especialidades especificas?");
        System.out.println("1.Sim 2.Não");
        opcao = sc.nextInt();
        sc.nextLine();
        while(opcao==1){
            System.out.println("\nDigite a especialidade desejada:");
            especialidades.add(sc.nextLine());
            System.out.println("\nDeseja incluir mais especialidades?");
            System.out.println("1.Sim 2.Não");
            opcao = sc.nextInt();
            sc.nextLine();            
        }
        PlanodeSaude plano = new PlanodeSaude(nomePlano, valorDesconto, especialidades);
        planoServicos.cadastrarPlano(plano);
        System.out.println("\nPlano cadastrado!");
        delay(1);
    }
}
