package br.santosfyuri;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class SaleProcess {

    private final NFe nfe;
    private final Boleto boleto;

    public SaleProcess(SalesModuleFactory salesModuleFactory) {
        this.nfe = salesModuleFactory.createNFe();
        this.boleto = salesModuleFactory.createBoleto();
    }

    public void execute(List<Product> products) {
        final BigDecimal total = products.stream()
                .map(p -> p.getPrice().multiply(new BigDecimal(p.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        final BigDecimal calculatedTax = nfe.calculateTax(total);
        nfe.generate();
        final String productsDescription = products.stream()
                .map(p -> p.getName() + " - " + p.getQuantity() + " - " + "R$" + p.getPrice().setScale(2, RoundingMode.HALF_UP))
                .collect(Collectors.joining(","));
        final BigDecimal totalWithTax = total.add(calculatedTax);
        boleto.send(productsDescription, totalWithTax);
    }
}
