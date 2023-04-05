package br.santosfyuri.console;


import br.santosfyuri.LogPrinter;

public class ConsoleLogPrinter implements LogPrinter {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
