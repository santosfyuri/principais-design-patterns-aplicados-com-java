package br.santosfyuri.model;

public enum Type {

    NEW("New movie"),
    OLD("Old movie");

    private final String description;

    Type(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
