package Persistencia;

import Entidades.PacienteEspecial;
import Entidades.PlanodeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PacientesEspeciaisPercistencia {

    private final String nomeArquivo = "Application/dados/pacientes_especiais.csv";
    private Path caminhoArquivo;

    public void salvarPacientesEspeciais(ArrayList<PacienteEspecial> pacientesEspeciais){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Nome,Idade,CPF,Plano de Saude");
                escritor.newLine();
                
                for(PacienteEspecial pacienteEspecial : pacientesEspeciais){
                    String linha = String.format("%s,%d,%s,%s", pacienteEspecial.getNome(),pacienteEspecial.getIdade(),pacienteEspecial.getCpf(),pacienteEspecial.getPlano().getNome());
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo pacientes especiais" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }

    public ArrayList<PacienteEspecial> carregarPacientesEspeciais(){
        ArrayList<PacienteEspecial> pacientesEspeciais = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);

        if(!Files.exists(caminhoArquivo))return pacientesEspeciais;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 4){
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String cpf = dados[2];
                    String nomePlano = dados[3];
                    PlanodeSaude planoVazio = new PlanodeSaude(nomePlano, 0);
                    PacienteEspecial pacienteLido = new PacienteEspecial(planoVazio, nome, idade, cpf);
                    pacientesEspeciais.add(pacienteLido);
                }
                else System.out.println("csv formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo "+ e.getMessage());
        }
        return pacientesEspeciais;
    }
}
