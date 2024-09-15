package br.ufes.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonLogWriter implements LogWriter {

    private String filePath;

    public JsonLogWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeLog(String mensagem) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            String json = String.format("{\"mensagem\": \"%s\", \"timestamp\": \"%s\"}",
                                        mensagem, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            fw.write(json + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever log em JSON: " + e.getMessage());
        }
    }
}