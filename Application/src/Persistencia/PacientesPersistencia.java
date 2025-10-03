package Persistencia;

import Entidades.Paciente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PacientesPersistencia {

    private final String nomeArquivo = "Application/dados/pacientes.csv";

    public void salvarPacientes(ArrayList<Paciente> pacientes){
        try{
            Path caminhoArquivo = Paths.get("Application/dados/");
            Files.createDirectories(caminhoArquivo);
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))){
                escritor.write("Nome,Idade,CPF");
                escritor.newLine();
                
                for(Paciente paciente : pacientes){
                    String linha = String.format("%s,%d,%s", paciente.getNome(),paciente.getIdade(),paciente.getCpf());
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
            catch(IOException e){
                System.out.println("erro ao salvar o arquivo" + e.getMessage());
            }
            
        }
        catch(IOException ex){
            System.out.println("erro ao criar pasta dados" + ex.getMessage());
        }

    }
}
