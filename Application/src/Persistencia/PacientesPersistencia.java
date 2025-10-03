package Persistencia;

import Entidades.Paciente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PacientesPersistencia {

    private final String nomeArquivo = "Application/dados/pacientes.csv";
    private Path caminhoArquivo;

    public void salvarPacientes(ArrayList<Paciente> pacientes){
        try{
            caminhoArquivo = Paths.get("Application/dados/");
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

    public ArrayList<Paciente> carregarPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        caminhoArquivo = Paths.get(nomeArquivo);

        if(!Files.exists(caminhoArquivo))return pacientes;
        
        try(BufferedReader leitor = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            leitor.readLine();
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(",");
                if(dados.length == 3){
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String cpf = dados[2];
                    Paciente pacienteLido = new Paciente(nome,idade,cpf);
                    pacientes.add(pacienteLido);
                }
                else System.out.println("csv formatado incorretamente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo "+ e.getMessage());
        }
        return pacientes;
    }
}
