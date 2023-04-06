package br.santosfyuri.impl;

import br.santosfyuri.BackupService;
import br.santosfyuri.model.Movie;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BackupServiceImpl implements BackupService {
    @Override
    public void generateFile(Movie movie) {
        XStream xstream = new XStream();
        xstream.alias("movie", Movie.class);
        OutputStream out;
        System.out.println("Generating external movie backup...");
        try {
            out = new FileOutputStream(movie.getName() + ".xml");
            xstream.toXML(movie, out);
            System.out.println("Successfully completing backup...");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error generating movie backup.", e);
        }

    }
}
