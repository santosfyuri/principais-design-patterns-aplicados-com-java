package br.santosfyuri.builder;

import br.santosfyuri.EntityBuilder;
import br.santosfyuri.entity.LegalPersonInvoice;
import br.santosfyuri.entity.Product;

import java.util.ArrayList;
import java.util.Date;

import static br.santosfyuri.entity.Invoice.Helper.parseDate;

public class LegalPersonInvoiceBuilder extends EntityBuilder<LegalPersonInvoice> {
    protected LegalPersonInvoiceBuilder(LegalPersonInvoice entity) {
        super(entity);
    }

    public static LegalPersonInvoiceBuilder create() {
        return new LegalPersonInvoiceBuilder(new LegalPersonInvoice());
    }

    public static LegalPersonInvoiceBuilder from(final LegalPersonInvoice entity) {
        return new LegalPersonInvoiceBuilder(entity);
    }

    public LegalPersonInvoiceBuilder number(String number) {
        this.entity.setNumber(number);
        return this;
    }

    public LegalPersonInvoiceBuilder date(Date date) {
        this.entity.setDate(date);
        return this;
    }

    public LegalPersonInvoiceBuilder date(String date) {
        this.entity.setDate(parseDate(date));
        return this;
    }

    public LegalPersonInvoiceBuilder product(Product product) {
        if (this.entity.getProducts() == null) {
            this.entity.setProducts(new ArrayList<>());
        }
        this.entity.getProducts().add(product);
        return this;
    }
}
