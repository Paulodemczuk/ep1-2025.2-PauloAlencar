package Entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String local;
    private int status;
    private LocalDateTime dataHora;
    private String diagnostico;
    private int idConsulta;

    public Consulta(){
        this.paciente = new Paciente();
        this.medico = new Medico();
        this.local = "";
        this.status = 0;
        this.dataHora = LocalDateTime.now();
        this.diagnostico = " ";
        this.idConsulta = 0;
    }

    public Consulta(int idConsulta, Paciente paciente, Medico medico,String local, int status, LocalDateTime dataHora,String diagnostico){
        this.paciente = paciente;
        this.medico = medico;
        this.local = local;
        this.status = status;
        this.dataHora = dataHora;
        this.diagnostico = diagnostico;
        this.idConsulta = idConsulta;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    public Paciente getPaciente(){
        return this.paciente;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }
    public Medico getMedico(){
        return this.medico;
    }

    public void setLocal(String local){
        this.local = local;
    }
    public String getLocal(){
        return this.local;
    }

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status; //0 = agendada, 1 = concluida, 2 = cancelada
    }

    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }
    public LocalDateTime getDataHora(){
        return this.dataHora;
    }

    public String getDataHoraFormatada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        String dataHoraFormatada = dataHora.format(formatter);
        return dataHoraFormatada;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    public double valorConsulta(){
        double aPagar;
        if(paciente instanceof PacienteEspecial){
            double desconto = ((PacienteEspecial)paciente).getPlano().getValorDesconto();
            for(String especialidade : ((PacienteEspecial)paciente).getPlano().getEspecialidades()){
                if(especialidade.equals(medico.getEspecialidade())){
                    desconto -= 0.1;
                    break;
                }
            }
            aPagar = medico.getCustoConsulta() * desconto;
            return aPagar;
        }
        else return medico.getCustoConsulta();
    }
}
