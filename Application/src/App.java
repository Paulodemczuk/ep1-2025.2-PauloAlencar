import Menus.*;
import static Menus.Cores.delay;
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
        MenuCadastro menuCadastro = new MenuCadastro(hospitalServicos);
        menuPrincipal(scanner,menuPaciente,menuMedico,menuCadastro);

    
    }

    public static void menuPrincipal(Scanner sc,MenuPaciente menuPaciente,MenuMedico menuMedico, MenuCadastro menuCadastro){
        
        int menu = -1;
        while (menu != 0) {
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

                case 4:
                    delay(1);
                    menuCadastro.acessarMenuCadastro(sc);
                    break;               
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Escolha uma alternativa valida");
                    delay(1);
            }            
        }
        //System.out.println("O menu escolhido foi: "+ menu);
    }
    public static void exibirMenuPrincipal(){
        System.out.println();
        System.out.println("-----Menu principal------");
        System.out.println(Cores.YELLOW +"1. Menu Paciente"+Cores.RESET);
        System.out.println("2. Menu Medico");
        System.out.println("3. Menu Relatórios");
        System.out.println("4. Menu Cadastramento");
    }
}
