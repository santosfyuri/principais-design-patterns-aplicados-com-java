package br.santosfyuri.builder;

import br.santosfyuri.EntityBuilder;
import br.santosfyuri.entity.NaturalPersonInvoice;
import br.santosfyuri.entity.Product;

import java.util.ArrayList;
import java.util.Date;

import static br.santosfyuri.entity.Invoice.Helper.parseDate;

public class NaturalPersonInvoiceBuilder extends EntityBuilder<NaturalPersonInvoice> {
    protected NaturalPersonInvoiceBuilder(NaturalPersonInvoice entity) {
        super(entity);
    }

    public static NaturalPersonInvoiceBuilder create() {
        return new NaturalPersonInvoiceBuilder(new NaturalPersonInvoice());
    }

    public static NaturalPersonInvoiceBuilder from(final NaturalPersonInvoice entity) {
        return new NaturalPersonInvoiceBuilder(entity);
    }

    public NaturalPersonInvoiceBuilder number(String number) {
        this.entity.setNumber(number);
        return this;
    }

    public NaturalPersonInvoiceBuilder date(Date date) {
        this.entity.setDate(date);
        return this;
    }

    public NaturalPersonInvoiceBuilder date(String date) {
        this.entity.setDate(parseDate(date));
        return this;
    }

    public NaturalPersonInvoiceBuilder product(Product product) {
        if (this.entity.getProducts() == null) {
            this.entity.setProducts(new ArrayList<>());
        }
        this.entity.getProducts().add(product);
        return this;
    }
}
