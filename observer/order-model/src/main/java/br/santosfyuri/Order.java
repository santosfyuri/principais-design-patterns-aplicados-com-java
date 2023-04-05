package br.santosfyuri;

import java.math.BigDecimal;

public class Order {

    private String description;
    private BigDecimal price;

    public Order(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + this.getDescription()
                + "\nPrice: " + this.getPrice();
    }
}
