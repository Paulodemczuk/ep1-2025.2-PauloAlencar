package Persistencia;

import Entidades.*;
import Servicos.*;
public class HospitalPersistencia {
    private PacientesPersistencia pacientesPersistencia;
    private PacientesEspeciaisPercistencia pacientesEspeciaisPercistencia;
    private PlanoPersistencia planoPersistencia;                           
    private MedicosPersistencia medicosPersistencia;
    private InternacaoPersistencia internacaoPersistencia;
    private ConsultaPersistencia consultaPersistencia;

    public HospitalPersistencia(){
        this.pacientesPersistencia = new PacientesPersistencia();
        this.pacientesEspeciaisPercistencia = new PacientesEspeciaisPercistencia();
        this.planoPersistencia = new PlanoPersistencia();
        this.medicosPersistencia = new MedicosPersistencia();
        this.internacaoPersistencia = new InternacaoPersistencia();
        this.consultaPersistencia = new ConsultaPersistencia();
    }

    public void salvarHospital(PacienteServicos pacienteServicos, MedicoServicos medicoServicos, PlanoServicos planoServicos, ConsultaServicos consultaServicos, InternacaoServicos internacaoServicos){
        pacientesPersistencia.salvarPacientes(pacienteServicos.getPacientes());
        pacientesEspeciaisPercistencia.salvarPacientesEspeciais(pacienteServicos.getPacientesEspeciais());
        medicosPersistencia.salvarMedicos(medicoServicos.getMedicos());
        planoPersistencia.salvarPlanos(planoServicos.getPlanosdeSaude());
        consultaPersistencia.salvarConsultas(consultaServicos.getConsultas());
        internacaoPersistencia.salvarInternacoes(internacaoServicos.getInternacoes());
    }
    public void salvarHospital(HospitalServicos hospitalServicos){
        pacientesPersistencia.salvarPacientes(hospitalServicos.getPacienteServicos().getPacientes());
        pacientesEspeciaisPercistencia.salvarPacientesEspeciais(hospitalServicos.getPacienteServicos().getPacientesEspeciais());
        medicosPersistencia.salvarMedicos(hospitalServicos.getMedicoServicos().getMedicos());
        planoPersistencia.salvarPlanos(hospitalServicos.getPlanoServicos().getPlanosdeSaude());
        consultaPersistencia.salvarConsultas(hospitalServicos.getConsultaServicos().getConsultas());
        internacaoPersistencia.salvarInternacoes(hospitalServicos.getInternacaoServicos().getInternacoes());
    }

    public void carregarHospital(HospitalServicos hospitalServicos){
        hospitalServicos.getPacienteServicos().setPacientes(pacientesPersistencia.carregarPacientes());
        hospitalServicos.getPacienteServicos().setPacientesEspeciais(pacientesEspeciaisPercistencia.carregarPacientesEspeciais());
        hospitalServicos.getMedicoServicos().setMedicos(medicosPersistencia.carregarMedicos());
        hospitalServicos.getPlanoServicos().setPlanosdeSaude(planoPersistencia.carregarPlanos());
        hospitalServicos.getConsultaServicos().setConsultas(consultaPersistencia.carregarConsultas(hospitalServicos.getPacienteServicos(), hospitalServicos.getMedicoServicos()));
        hospitalServicos.getInternacaoServicos().setInternacoes(internacaoPersistencia.carregarInternacoes(hospitalServicos.getPacienteServicos(), hospitalServicos.getMedicoServicos()));
        carregarConsultas(hospitalServicos.getPacienteServicos(), hospitalServicos.getConsultaServicos());
        carregarPlanos(hospitalServicos.getPacienteServicos(), hospitalServicos.getPlanoServicos());
        carregarInternacoes(hospitalServicos.getPacienteServicos(), hospitalServicos.getInternacaoServicos());
    }
        
    public void carregarPlanos(PacienteServicos pacienteServicos,PlanoServicos planoServicos){
        for(PacienteEspecial paciente : pacienteServicos.getPacientesEspeciais()){
            for(PlanodeSaude plano : planoServicos.getPlanosdeSaude()){
                if(paciente.getPlano().getNome().equals(plano.getNome())){
                    paciente.setPlano(plano);
                    break;
                }
            }
        }
    }

    public void carregarConsultas(PacienteServicos pacienteServicos,ConsultaServicos consultaServicos){
        for(Paciente paciente : pacienteServicos.getPacientes()){
            for(Consulta consulta : consultaServicos.getConsultas()){
                if(consulta.getPaciente().getCpf().equals(paciente.getCpf())){
                    paciente.adicionarConsulta(consulta);
                }
            }
        }
        for(PacienteEspecial paciente : pacienteServicos.getPacientesEspeciais()){
            for(Consulta consulta : consultaServicos.getConsultas()){
                if(consulta.getPaciente().getCpf().equals(paciente.getCpf())){
                    paciente.adicionarConsulta(consulta);
                }
            }
        }
    }

    public void carregarInternacoes(PacienteServicos pacienteServicos, InternacaoServicos internacaoServicos){
        for(Paciente paciente : pacienteServicos.getPacientes()){
            for(Internacao internacao : internacaoServicos.getInternacoes()){
                if(internacao.getPaciente().getCpf().equals(paciente.getCpf())){
                    paciente.adicionarInternacao(internacao);
                }
            }
        }
        for(PacienteEspecial paciente : pacienteServicos.getPacientesEspeciais()){
            for(Internacao internacao : internacaoServicos.getInternacoes()){
                if(internacao.getPaciente().getCpf().equals(paciente.getCpf())){
                    paciente.adicionarInternacao(internacao);
                }
            }
        }
    }

    public PacientesPersistencia getPacientesPersistencia() {
        return pacientesPersistencia;
    }

    public void setPacientesPersistencia(PacientesPersistencia pacientesPersistencia) {
        this.pacientesPersistencia = pacientesPersistencia;
    }

    public PacientesEspeciaisPercistencia getPacientesEspeciaisPercistencia() {
        return pacientesEspeciaisPercistencia;
    }

    public void setPacientesEspeciaisPercistencia(PacientesEspeciaisPercistencia pacientesEspeciaisPercistencia) {
        this.pacientesEspeciaisPercistencia = pacientesEspeciaisPercistencia;
    }

    public PlanoPersistencia getPlanoPersistencia() {
        return planoPersistencia;
    }

    public void setPlanoPersistencia(PlanoPersistencia planoPersistencia) {
        this.planoPersistencia = planoPersistencia;
    }

    public MedicosPersistencia getMedicosPersistencia() {
        return medicosPersistencia;
    }

    public void setMedicosPersistencia(MedicosPersistencia medicosPersistencia) {
        this.medicosPersistencia = medicosPersistencia;
    }

    public InternacaoPersistencia getInternacaoPersistencia() {
        return internacaoPersistencia;
    }

    public void setInternacaoPersistencia(InternacaoPersistencia internacaoPersistencia) {
        this.internacaoPersistencia = internacaoPersistencia;
    }

    public ConsultaPersistencia getConsultaPersistencia() {
        return consultaPersistencia;
    }

    public void setConsultaPersistencia(ConsultaPersistencia consultaPersistencia) {
        this.consultaPersistencia = consultaPersistencia;
    }
}
