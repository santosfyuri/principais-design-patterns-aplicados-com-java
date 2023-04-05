package br.santosfyuri.textfile;

import br.santosfyuri.LogPrinter;
import br.santosfyuri.Logger;

public class TextFileCreator extends Logger {

    final String fileName;

    public TextFileCreator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected LogPrinter loggerCreate() {
        return new TextFilePrinter(fileName);
    }
}
