package br.santosfyuri;

import br.santosfyuri.builder.LegalPersonInvoiceBuilder;
import br.santosfyuri.builder.NaturalPersonInvoiceBuilder;
import br.santosfyuri.builder.ProductBuilder;
import br.santosfyuri.entity.LegalPersonInvoice;
import br.santosfyuri.entity.NaturalPersonInvoice;

public class BuilderExample {

    public static void main(String[] args) {
        NaturalPersonInvoice naturalPersonInvoice = NaturalPersonInvoiceBuilder.create()
                .number("1")
                .date("04/04/2023")
                .product(ProductBuilder.create()
                        .name("Tênis esportivo")
                        .price(299.9)
                        .quantity(1)
                        .build())
                .build();

        LegalPersonInvoice legalPersonInvoice = LegalPersonInvoiceBuilder.create()
                .number("1")
                .date("04/04/2023")
                .product(ProductBuilder.create()
                        .name("Tênis esportivo")
                        .price(299.9)
                        .quantity(1)
                        .build())
                .product(ProductBuilder.create()
                        .name("Bermuda")
                        .price(69.9)
                        .quantity(1)
                        .build())
                .product(ProductBuilder.create()
                        .name("Camiseta")
                        .price(56.9)
                        .quantity(1)
                        .build())
                .build();

        System.out.println(naturalPersonInvoice.getCalculatedTax());
        System.out.println(legalPersonInvoice.getCalculatedTax());
    }
}
