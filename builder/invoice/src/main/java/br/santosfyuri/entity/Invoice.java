package br.santosfyuri.entity;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Invoice {

    protected String number;
    protected Date date;
    protected List<Product> products;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return getProducts().stream()
                .map(product -> product.getPrice().multiply(new BigDecimal(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public abstract BigDecimal getCalculatedTax();

    public static class Helper {

        public static Date parseDate(String date) {
            Date formatedDate = null;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                formatedDate = format.parse(date);
            } catch (ParseException e) {
                System.out.println("Invalid date. Error: " + e.getMessage());
            }
            return formatedDate;
        }

    }
}
