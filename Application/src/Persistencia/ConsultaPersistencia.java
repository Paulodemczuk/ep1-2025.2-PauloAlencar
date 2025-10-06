package Persistencia;

import Entidades.Consulta;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsultaPersistencia {

    private final String nomeArquivo = "Application/dados/consultas.csv";
    private Path caminhoArquivo;

    public void salvarConsultas(ArrayList<Consulta> consultas){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Local,Status,Paciente-CPF,Medico-CRM,Data-Hora,Diagnostico,Id da Consulta");
                escritor.newLine();
                
                for(Consulta consulta : consultas){
                    String linha = String.format("%s,%d,%s,%s,%s,%s,%d", 
                    consulta.getLocal(),
                    consulta.getStatus(),
                    consulta.getPaciente().getCpf(),
                    consulta.getMedico().getCrm(),
                    consulta.getDataHoraFormatada(),
                    consulta.getDiagnostico(),
                    consulta.getIdConsulta()
                    );
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo consultas.csv" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }

    public ArrayList<Consulta> carregarConsultas(PacienteServicos ps, MedicoServicos ms){
        ArrayList<Consulta> consultas = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

        if(!Files.exists(caminhoArquivo))return consultas;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 7){
                    String local = dados[0];
                    int status = Integer.parseInt(dados[1]);
                    String cpf = dados[2];
                    String crm = dados[3];
                    LocalDateTime datahora = LocalDateTime.parse(dados[4], formatter);
                    String diagnostico = dados[5];
                    int idConsulta = Integer.parseInt(dados[6]);
                    if(ps.getPaciente(cpf).getNome().equals("")){
                        Consulta consultaLida = new Consulta(idConsulta,ps.getPacienteEspecial(cpf),ms.getMedico(crm),local,status,datahora,diagnostico);
                        consultas.add(consultaLida);
                    }else {
                        Consulta consultaLida = new Consulta(idConsulta,ps.getPaciente(cpf),ms.getMedico(crm),local,status,datahora,diagnostico);
                        consultas.add(consultaLida);                        
                    }
                }
                else System.out.println("csv consultas formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo "+ e.getMessage());
        }
        return consultas;
    }
}
