package br.santosfyuri.builder;

import br.santosfyuri.EntityBuilder;
import br.santosfyuri.entity.Product;

import java.math.BigDecimal;

public class ProductBuilder extends EntityBuilder<Product> {

    protected ProductBuilder(Product entity) {
        super(entity);
    }

    public static ProductBuilder create() {
        return new ProductBuilder(new Product());
    }

    public static ProductBuilder from(final Product entity) {
        return new ProductBuilder(entity);
    }

    public ProductBuilder name(String name) {
        this.entity.setName(name);
        return this;
    }

    public ProductBuilder price(String price) {
        this.entity.setPrice(new BigDecimal(price));
        return this;
    }

    public ProductBuilder price(Double price) {
        this.entity.setPrice(new BigDecimal(price));
        return this;
    }

    public ProductBuilder price(BigDecimal price) {
        this.entity.setPrice(price);
        return this;
    }

    public ProductBuilder quantity(Integer quantity) {
        this.entity.setQuantity(quantity);
        return this;
    }
}
