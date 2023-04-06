package br.santosfyuri;

import java.io.Serializable;

public class Contact implements Serializable {

    private Integer code;
    private String name;
    private String email;

    public Contact(Integer code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
