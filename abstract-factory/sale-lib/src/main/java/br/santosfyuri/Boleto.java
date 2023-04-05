package br.santosfyuri;

import java.math.BigDecimal;

public interface Boleto {

    void send(String consumption, BigDecimal amount);
}
