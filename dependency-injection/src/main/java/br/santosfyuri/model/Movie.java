package br.santosfyuri.model;

import java.util.Date;

public class Movie {
    private String name;
    private Date releaseDate;
    private Type type;

    public Movie() {}

    public Movie(String name, Date releaseDate, Type type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
