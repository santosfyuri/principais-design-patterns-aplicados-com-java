package br.santosfyuri;

import br.santosfyuri.model.Movie;

public interface MovieService {
    void registerMovie(Movie movie);
    boolean isOldMovie(Movie movie);
}
