package br.santosfyuri;

import java.math.BigDecimal;

public interface NFe {

    void generate();
    BigDecimal calculateTax(BigDecimal amount);
}
