import Menus.*;
import static Menus.Cores.delay;
import static Menus.Cores.limparTela;
import Persistencia.HospitalPersistencia;
import Servicos.HospitalServicos;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalPersistencia hospitalPersistencia = new HospitalPersistencia();
        HospitalServicos hospitalServicos = new HospitalServicos();
        hospitalPersistencia.carregarHospital(hospitalServicos);
        MenuPaciente menuPaciente = new MenuPaciente(hospitalServicos);
        MenuMedico menuMedico = new MenuMedico(hospitalServicos);
        MenuRelatorio menuRelatorio = new MenuRelatorio(hospitalServicos);
        MenuCadastro menuCadastro = new MenuCadastro(hospitalServicos);

        menuPrincipal(scanner,menuPaciente,menuMedico,menuCadastro,menuRelatorio,hospitalPersistencia,hospitalServicos);

    
    }

    public static void menuPrincipal(Scanner sc,MenuPaciente menuPaciente,MenuMedico menuMedico, MenuCadastro menuCadastro, MenuRelatorio menuRelatorio,HospitalPersistencia hospitalPersistencia,HospitalServicos hospitalServicos){
        
        int menu = -1;
        while (menu != 0 && menu!=9) {
            exibirMenuPrincipal(); 
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1: 
                    delay(1);
                    menuPaciente.acessarMenuPaciente(sc);
                    break;
                case 2:
                    delay(1);
                    menuMedico.acessarMenuMedico(sc);
                    break;
                case 3:
                    delay(1);
                    menuRelatorio.acessarMenuRelatorio(sc);
                    break;
                case 4:
                    delay(1);
                    menuCadastro.acessarMenuCadastro(sc);
                    break;
                case 9:
                    System.out.println("Encerrando sem salvar...");
                    break;               
                case 0:
                    System.out.println("Salvando dados e encerrando programa...");
                    hospitalPersistencia.salvarHospital(hospitalServicos);
                    break;
                default:
                    System.out.println("\nEscolha uma alternativa valida");
                    delay(1);
            }            
        }
        //System.out.println("O menu escolhido foi: "+ menu);
    }
    public static void exibirMenuPrincipal(){
        limparTela();
        System.out.println();
        System.out.println(Cores.CYAN+"+------------------------+"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+"     Menu Principal     "+Cores.CYAN+"|");
        System.out.println(Cores.CYAN+"+------------------------+" + Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  1. Menu Paciente      "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  2. Menu Medico        "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  3. Menu Relatórios    "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  4. Menu Cadastramento "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "                        "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  9. Sair sem salvar    "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"|"+Cores.RESET+ "  0. Salvar e sair      "+Cores.CYAN+"|"+Cores.RESET);
        System.out.println(Cores.CYAN+"+------------------------+" + Cores.RESET);
    }
}
