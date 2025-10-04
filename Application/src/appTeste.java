import Persistencia.MedicosPersistencia;
import Persistencia.PacientesEspeciaisPercistencia;
import Persistencia.PacientesPersistencia;
import Persistencia.PlanoPersistencia;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import Servicos.PlanoServicos;
public class appTeste {
    public static void main(String[] args) {
        PacienteServicos pServicos = new PacienteServicos();
        MedicoServicos mServicos = new MedicoServicos();
        PlanoServicos planoServicos= new PlanoServicos();
        PacientesPersistencia pPersistencia = new PacientesPersistencia();
        MedicosPersistencia mPersistencia = new MedicosPersistencia();
        PacientesEspeciaisPercistencia pePersistencia = new PacientesEspeciaisPercistencia();
        PlanoPersistencia planoPersistencia = new PlanoPersistencia();

        
        //planoPersistencia.salvarPlanos(planoServicos.getPlanosdeSaude());
        //mPersistencia.salvarMedicos(mServicos.getMedicos());
        //pPersistencia.salvarPacientes(pServicos.getPacientes());
        //pePersistencia.salvarPacientesEspeciais(pServicos.getPacientesEspeciais());
    }
}
