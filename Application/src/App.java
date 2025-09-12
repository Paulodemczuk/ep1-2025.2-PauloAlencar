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
        System.out.println("O menu escolhido foi: "+ menu);
    }
}
