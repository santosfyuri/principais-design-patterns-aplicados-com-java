package br.santosfyuri.textfile;

import br.santosfyuri.LogPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFilePrinter implements LogPrinter {

    private final String fileName;

    public TextFilePrinter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
