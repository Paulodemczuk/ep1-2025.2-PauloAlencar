import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("-----Menu principal------");
        System.out.println("1. Menu Paciente");
        System.out.println("2. Menu Medico");
        System.out.println("3. Menu Relatórios");
        System.out.println("4. Menu Cadastramento");
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();
        sc.close();
        switch (menu){
            case 1: 
                System.out.println("menu paciente");
                break;
            case 2: 
                System.out.println("menu medico");
                break;
        }
        System.out.println("O menu escolhido foi: "+ menu);
    }
}
