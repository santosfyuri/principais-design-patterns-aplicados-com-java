package br.santosfyuri.impl;

import br.santosfyuri.BackupService;
import br.santosfyuri.model.Movie;
import br.santosfyuri.MovieService;
import br.santosfyuri.model.Type;
import jakarta.inject.Inject;

import java.util.Calendar;

public class MovieServiceImpl implements MovieService {

    @Inject
    BackupService backupService;

    @Override
    public void registerMovie(Movie movie) {
        System.out.println("Starting the movie persistence process...");
        movie.setType(isOldMovie(movie) ? Type.OLD : Type.NEW);
        System.out.println("Saved successfully!");
        backupService.generateFile(movie);
    }

    @Override
    public boolean isOldMovie(Movie movie) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        return movie.getReleaseDate().before(calendar.getTime());
    }
}
