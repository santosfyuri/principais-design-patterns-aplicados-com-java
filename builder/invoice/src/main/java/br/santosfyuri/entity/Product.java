package br.santosfyuri.entity;

import br.santosfyuri.IEntity;

import java.math.BigDecimal;

public class Product implements IEntity<String> {

    private String name;
    private BigDecimal price;
    private Integer quantity;

    @Override
    public String getIdentifier() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
