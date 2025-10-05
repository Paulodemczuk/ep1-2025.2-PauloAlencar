package Servicos;

public class HospitalServicos {
    private PacienteServicos pacienteServicos;
    private MedicoServicos medicoServicos;
    private PlanoServicos planoServicos;
    private ConsultaServicos consultaServicos;
    private InternacaoServicos internacaoServicos;


    public HospitalServicos(){
        this.pacienteServicos = new PacienteServicos();
        this.medicoServicos = new MedicoServicos();
        this.planoServicos = new PlanoServicos();
        this.consultaServicos = new ConsultaServicos();
        this.internacaoServicos = new InternacaoServicos();
    }

    public PacienteServicos getPacienteServicos() {
        return pacienteServicos;
    }

    public void setPacienteServicos(PacienteServicos pacienteServicos) {
        this.pacienteServicos = pacienteServicos;
    }

    public MedicoServicos getMedicoServicos() {
        return medicoServicos;
    }

    public void setMedicoServicos(MedicoServicos medicoServicos) {
        this.medicoServicos = medicoServicos;
    }

    public PlanoServicos getPlanoServicos() {
        return planoServicos;
    }

    public void setPlanoServicos(PlanoServicos planoServicos) {
        this.planoServicos = planoServicos;
    }

    public ConsultaServicos getConsultaServicos() {
        return consultaServicos;
    }

    public void setConsultaServicos(ConsultaServicos consultaServicos) {
        this.consultaServicos = consultaServicos;
    }

    public InternacaoServicos getInternacaoServicos() {
        return internacaoServicos;
    }

    public void setInternacaoServicos(InternacaoServicos internacaoServicos) {
        this.internacaoServicos = internacaoServicos;
    }




}
