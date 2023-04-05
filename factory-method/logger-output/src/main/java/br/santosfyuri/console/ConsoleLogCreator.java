package br.santosfyuri.console;

import br.santosfyuri.LogPrinter;
import br.santosfyuri.Logger;

public class ConsoleLogCreator extends Logger {

    @Override
    protected LogPrinter loggerCreate() {
        return new ConsoleLogPrinter();
    }
}
