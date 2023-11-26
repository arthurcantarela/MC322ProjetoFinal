package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> implements IRepository<T> {
    protected String filePath;

    public Repository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void salvar(List<T> dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T dado : dados) {
                writer.write(objetoParaCsv(dado));
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao salvar: Arquivo não encontrado.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar: Erro de escrita.");
        }
    }

    @Override
    public List<T> carregar() {
        List<T> dados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dados.add(csvParaObjeto(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao carregar: Arquivo não encontrado.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar: Erro de leitura.");
        }
        return dados;
    }

    protected abstract String objetoParaCsv(T dado);

    protected abstract T csvParaObjeto(String csvLine);
}
