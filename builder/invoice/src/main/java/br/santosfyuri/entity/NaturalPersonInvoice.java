package br.santosfyuri.entity;

import br.santosfyuri.IEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NaturalPersonInvoice extends Invoice implements IEntity<String> {

    @Override
    public String getIdentifier() {
        return this.getNumber();
    }

    @Override
    public BigDecimal getCalculatedTax() {
        BigDecimal total = this.getTotal();
        total = total.multiply(new BigDecimal("1.07"));
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
