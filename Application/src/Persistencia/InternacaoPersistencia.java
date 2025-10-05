package Persistencia;

import Entidades.Internacao;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class InternacaoPersistencia {

    private final String nomeArquivo = "Application/dados/internacoes.csv";
    private Path caminhoArquivo;

    public void salvarInternacoes(ArrayList<Internacao> internacoes){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Quarto,Paciente-CPF,Medico-CRM,Data-Entrada,Data-Saida,Custo da Internacao,Id da Internacao");
                escritor.newLine();
                
                for(Internacao internacao : internacoes){
                    String linha = String.format(Locale.US,"%d,%s,%s,%s,%s,%.2f,%d", 
                    internacao.getQuarto(),
                    internacao.getPaciente().getCpf(),
                    internacao.getMedico().getCrm(),
                    internacao.getDataEntradaFormatada(),
                    internacao.getDataSaidaFormatada(),
                    internacao.getCustoInternacao(),
                    internacao.getIdInternacao()
                    );
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo internacoes.csv" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }

    public ArrayList<Internacao> carregarInternacoes(PacienteServicos ps, MedicoServicos ms){
        ArrayList<Internacao> internacoes = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(!Files.exists(caminhoArquivo))return internacoes;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 7){
                    int quarto = Integer.parseInt(dados[0]);
                    String cpf = dados[1];
                    String crm = dados[2];
                    LocalDate dataEntrada = LocalDate.parse(dados[3], formatter);
                    LocalDate dataSaida = LocalDate.parse(dados[4], formatter);
                    double custoInternacao = Double.parseDouble(dados[5]);
                    int idInternacao = Integer.parseInt(dados[6]);
                    Internacao internacaoLida = new Internacao(idInternacao,ps.getPaciente(cpf),ms.getMedico(crm),dataEntrada,dataSaida,quarto,custoInternacao);
                    internacoes.add(internacaoLida);
                }
                else System.out.println("csv internacoes formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo "+ e.getMessage());
        }
        return internacoes;
    }
}
