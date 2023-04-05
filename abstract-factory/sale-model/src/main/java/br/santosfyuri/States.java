package br.santosfyuri;

import java.math.BigDecimal;

public enum States {

    RS("Rio Grande do Sul", BigDecimal.valueOf(0.10)),
    SC("Rio de Janeiro", BigDecimal.valueOf(0.07)),
    PE("Pernambuco", BigDecimal.valueOf(0.06));

    private final String name;
    private final BigDecimal tax;

    States(String name, BigDecimal tax) {
        this.name = name;
        this.tax = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getTax() {
        return this.tax;
    }
}
