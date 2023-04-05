package br.santosfyuri;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {


    protected abstract LogPrinter loggerCreate();

    public void log(String message) {
        LogPrinter logger = loggerCreate();
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        logger.print(String.format("[%s] %s", date, message));
    }
}
