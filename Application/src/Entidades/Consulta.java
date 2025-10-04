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

    public Consulta(){
        this.paciente = new Paciente();
        this.medico = new Medico();
        this.local = "";
        this.status = 0;
        this.dataHora = LocalDateTime.now();
        this.diagnostico = " ";
    }

    public Consulta(Paciente paciente, Medico medico,String local, int status, LocalDateTime dataHora,String diagnostico){
        this.paciente = paciente;
        this.medico = medico;
        this.local = local;
        this.status = status;
        this.dataHora = dataHora;
        this.diagnostico = diagnostico;
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
        return status;
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
}
