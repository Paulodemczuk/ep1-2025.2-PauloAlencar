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
                escritor.write("Nome,Idade,CRM,Especialidade,Custo da Consulta,Horarios: segunda,terca,quarta,quinta,sexta,sabado,domingo");
                escritor.newLine();
                
                for(Medico medico : medicos){
                    String linha = String.format(Locale.US,"%s,%d,%s,%s,%.2f,%s,%s,%s,%s,%s,%s,%s", medico.getNome(),medico.getIdade(),medico.getCrm(),medico.getEspecialidade(),medico.getCustoConsulta(),medico.getHorarios(0),medico.getHorarios(1),medico.getHorarios(2),medico.getHorarios(3),medico.getHorarios(4),medico.getHorarios(5),medico.getHorarios(6));
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
                if(dados.length == 12){
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String crm = dados[2];
                    String especialidade = dados[3];
                    double custoConsulta = Double.parseDouble(dados[4]);
                    Medico medicoLido = new Medico(nome,idade,especialidade,crm,custoConsulta);
                    medicoLido.adicionarHorarios(0, dados[5]);
                    medicoLido.adicionarHorarios(1, dados[6]);
                    medicoLido.adicionarHorarios(2, dados[7]);
                    medicoLido.adicionarHorarios(3, dados[8]);
                    medicoLido.adicionarHorarios(4, dados[9]);
                    medicoLido.adicionarHorarios(5, dados[10]);
                    medicoLido.adicionarHorarios(6, dados[11]);
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
