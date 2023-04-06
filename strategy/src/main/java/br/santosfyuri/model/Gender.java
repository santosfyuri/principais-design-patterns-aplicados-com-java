package br.santosfyuri.model;

public enum Gender {

    M("Male"),
    F("Female"),
    O("Others");

    final private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
