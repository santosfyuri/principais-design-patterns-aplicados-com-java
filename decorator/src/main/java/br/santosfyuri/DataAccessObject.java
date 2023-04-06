package br.santosfyuri;

public interface DataAccessObject {

    void insert(Contact contact);

    Contact get(int code);

    void setFileName(String fileName);
}
