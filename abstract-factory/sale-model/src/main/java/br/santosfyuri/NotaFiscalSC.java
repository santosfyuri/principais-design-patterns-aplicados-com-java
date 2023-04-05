package br.santosfyuri;

import java.math.BigDecimal;

public class NotaFiscalSC implements NFe {

    final States state = States.SC;

    @Override
    public void generate() {
        System.out.println("\n----------------------------------");
        System.out.println("Gerando NFE para " + state.getName());
        System.out.println("----------------------------------\n");
    }

    @Override
    public BigDecimal calculateTax(BigDecimal total) {
        final BigDecimal calculatedTax = total.multiply(state.getTax());

        System.out.println("----------------------------------");
        System.out.println("Cálculo de impostos federais para " + state.getName() + ":\n");
        System.out.println("Valor da Nota Fiscal: " + total);
        System.out.println("Percentual do imposto: " + state.getTax());
        System.out.println("Valor do imposto: " + calculatedTax);
        System.out.println("\nValor total: " + total.add(calculatedTax));
        System.out.println("----------------------------------");

        return calculatedTax;
    }
}
