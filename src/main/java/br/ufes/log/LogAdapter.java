package br.ufes.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAdapter {

    private LogWriter logWriter;
    private String filePath;

    public LogAdapter(String formatoLog, String filePath) {
        this.filePath = filePath;
        setFormatoLog(formatoLog);
    }

    public void setFormatoLog(String formatoLog) {
        switch (formatoLog.toUpperCase()) {
            case "CSV":
                logWriter = new CsvLogWriter(filePath);
                break;
            case "JSON":
                logWriter = new JsonLogWriter(filePath);
                break;
            default:
                System.err.println("Formato de log não suportado.");
                logWriter = null;
        }
    }

    public void log(String operacao, String nome, String usuario, boolean sucesso, String mensagemFalha) {
        if (logWriter == null) {
            System.err.println("Adaptador de log não configurado.");
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String logMessage;

        if (sucesso) {
            logMessage = String.format("%s: %s, (%s, e %s);", operacao, nome, timestamp, usuario);
        } else {
            logMessage = String.format("Ocorreu a falha %s ao realizar a \"%s do contato %s, (%s, e %s).",
                                       mensagemFalha, operacao, nome, timestamp, usuario);
        }

        logWriter.writeLog(logMessage);
    }
}