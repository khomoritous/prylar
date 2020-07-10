/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 *
 * @author monde
 */
public class LogHandler {
  
  private static final String LOG_FILE_NAME = "prylsamling-log.txt";
    
    private PrintWriter logFile = null;
    
    /**
     * Skapar en ny instans.
     * @throws java.io.IOException Kastas då I/O-strömmar inte fungerar.
     */
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(new File(LOG_FILE_NAME),true),true);
    }
    
    /**
     * Skriver till logfilen.
     * 
     * @param exception Instans av <code>Exception</code> som skrivs till
     * logfilen.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(",Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
        
    } 
    
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
    
  
}
