import Menus.*;
import static Menus.Cores.delay;
import Persistencia.PacientesEspeciaisPercistencia;
import Persistencia.PacientesPersistencia;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacientesPersistencia pacientesPersistencia = new PacientesPersistencia();
        PacientesEspeciaisPercistencia pacientesEspeciaisPercistencia = new PacientesEspeciaisPercistencia();

        MenuPaciente menuPaciente = new MenuPaciente();
        menuPrincipal(scanner,menuPaciente);

    
    }

    public static void menuPrincipal(Scanner sc,MenuPaciente menuPaciente){
        
        int menu = -1;
        while (menu != 0) {
            exibirMenuPrincipal(); 
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1: 
                    delay(2);
                    menuPaciente.acessarMenuPaciente(sc);
                    break;
                case 2: 
                    System.out.println("menu medico");
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
        System.out.println("-----Menu principal------");
        System.out.println(Cores.YELLOW +"1. Menu Paciente"+Cores.RESET);
        System.out.println("2. Menu Medico");
        System.out.println("3. Menu Relatórios");
        System.out.println("4. Menu Cadastramento");
    }
}
