package Entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Internacao {
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int quarto;
    private double custoInternacao;
    private int idInternacao;

    public Internacao(){
        this.paciente = new Paciente();
        this.medico = new Medico();
        this.dataEntrada = LocalDate.now();
        this.dataSaida = LocalDate.now().minusDays(1);
        this.quarto = 0;
        this.custoInternacao = 0;
        this.idInternacao = 0;
    }

    public Internacao(int idInternacao,Paciente paciente, Medico medico, LocalDate dataEntrada, LocalDate dataSaida, int quarto, double custoInternacao){
        this.paciente = paciente;
        this.medico = medico;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
        this.custoInternacao = custoInternacao;
        this.idInternacao = idInternacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public double getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(double custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public int getDuracaoInternacao(){
        Period diasInternacao = Period.between(dataEntrada, dataSaida);
        return diasInternacao.getDays();// retorna -1 se o paciente ainda esta internado
    }

    public String getDataEntradaFormatada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataEntradaFormatada = dataEntrada.format(formatter);
        return dataEntradaFormatada;
    }

    public String getDataSaidaFormatada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataSaidaFormatada = dataSaida.format(formatter);
        return dataSaidaFormatada;
    }

    public int getIdInternacao() {
        return idInternacao;
    }

    public void setIdInternacao(int idInternacao) {
        this.idInternacao = idInternacao;
    }

    public double valorInternaçao(){
        if(this.getDuracaoInternacao()==-1)return 0.00;
        double desconto= 1;
        if(paciente instanceof PacienteEspecial){
            desconto = ((PacienteEspecial)paciente).getPlano().getValorDesconto();
        }
        double valorPagar = (getCustoInternacao()*getDuracaoInternacao())*desconto;
        return valorPagar;
    }
}
