import Entidades.*;
import Menus.MenuPaciente;
public class appTeste {
    public static void main(String[] args) {
        Paciente machucado = new Paciente();
        machucado.setNome("Super Tadinho");
        machucado.setIdade(70);
        machucado.setCpf("123.321.892-20");
        machucado.printInformacoes();
        Medico med1 = new Medico();
        med1.setNome("Doutor forte");
        med1.setCrm("21345 SP");
        med1.setEspecialidade("Cardiologista");
        med1.printInformacoes();
        MenuPaciente.exibirMenuPaciente();
    }
}
