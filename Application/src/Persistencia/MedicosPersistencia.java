package Persistencia;

import Entidades.Medico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;

public class MedicosPersistencia {

    private final String nomeArquivo = "Application/dados/medicos.csv";
    private Path caminhoArquivo;

    public void salvarMedicos(ArrayList<Medico> medicos){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Nome,Idade,CRM,Especialidade,Custo da Consulta");
                escritor.newLine();
                
                for(Medico medico : medicos){
                    String linha = String.format(Locale.US,"%s,%d,%s,%s,%.2f", medico.getNome(),medico.getIdade(),medico.getCrm(),medico.getEspecialidade(),medico.getCustoConsulta());
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo medicos.csv" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }

    public ArrayList<Medico> carregarMedicos(){
        ArrayList<Medico> medicos = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);

        if(!Files.exists(caminhoArquivo))return medicos;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 5){
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String crm = dados[2];
                    String especialidade = dados[3];
                    double custoConsulta = Double.parseDouble(dados[4]);
                    Medico medicoLido = new Medico(nome,idade,crm,especialidade,custoConsulta);
                    medicos.add(medicoLido);
                }
                else System.out.println("csv medicos formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo medicos "+ e.getMessage());
        }
        return medicos;
    }
}
