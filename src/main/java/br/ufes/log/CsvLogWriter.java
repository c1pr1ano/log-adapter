package br.ufes.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvLogWriter implements LogWriter {

    private String filePath;

    public CsvLogWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeLog(String mensagem) {
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(mensagem);
        } catch (IOException e) {
            System.err.println("Erro ao escrever log em CSV: " + e.getMessage());
        }
    }
}