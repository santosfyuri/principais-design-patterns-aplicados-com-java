package br.santosfyuri;

import br.santosfyuri.context.WeldContext;
import br.santosfyuri.model.Movie;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MovieExample {
    public static void main(String[] args) throws ParseException {
        Movie movie = new Movie();

        String name = JOptionPane.showInputDialog("Enter movie name:");
        String formatedDate = JOptionPane.showInputDialog("Enter the movie's release date [DD/MM/YYYY]:");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        movie.setReleaseDate(formatter.parse(formatedDate));
        movie.setName(name);

        MovieService movieService = WeldContext.INSTANCE.getBean(MovieService.class);
        movieService.registerMovie(movie);
    }
}
