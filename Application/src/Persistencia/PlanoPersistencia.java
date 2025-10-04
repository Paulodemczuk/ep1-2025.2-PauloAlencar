package Persistencia;

import Entidades.PlanodeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class PlanoPersistencia {

    private final String nomeArquivo = "Application/dados/planos_de_saude.csv";
    private Path caminhoArquivo;

    public void salvarPlanos(ArrayList<PlanodeSaude> planos){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Nome do Plano,Valor do desconto,Especialidades");
                escritor.newLine();
                
                for(PlanodeSaude planodeSaude : planos){
                    String linha = String.format(Locale.US,"%s,%.2f,", planodeSaude.getNome(),planodeSaude.getValorDesconto());
                    for(String especialidades : planodeSaude.getEspecialidades()){
                        linha += String.format("%s ",especialidades);
                    }
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo planos_de_saude" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }

    public ArrayList<PlanodeSaude> carregarPlanos(){
        ArrayList<PlanodeSaude> planos = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);

        if(!Files.exists(caminhoArquivo))return planos;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 3){
                    String nome = dados[0];
                    double valorDesconto = Double.parseDouble(dados[1]);
                    String[] especialidadesLidas = dados[2].split(" ");
                    ArrayList<String> especialidades = new ArrayList<>();
                    especialidades.addAll(Arrays.asList(especialidadesLidas));
                    PlanodeSaude planodeSaudeLido = new PlanodeSaude(nome,valorDesconto,especialidades);
                    planos.add(planodeSaudeLido);
                }
                else System.out.println("csv planos_de_saude formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo planos_de_saude "+ e.getMessage());
        }
        return planos;
    }
}
