package br.santosfyuri;

import java.math.BigDecimal;
import java.util.Arrays;

public class SaleExample {

    public static void main(String[] args) {
        SalesModuleFactory salesModuleFactory = new StoreFactory();

        SaleProcess saleProcess = new SaleProcess(salesModuleFactory);

        Product product1 = new Product();
        product1.setName("Tênis");
        product1.setQuantity(1);
        product1.setPrice(new BigDecimal("299.99"));

        Product product2 = new Product();
        product2.setName("Bermuda");
        product2.setQuantity(1);
        product2.setPrice(new BigDecimal("79.99"));

        Product product3 = new Product();
        product3.setName("Camiseta");
        product3.setQuantity(1);
        product3.setPrice(new BigDecimal("59.99"));


        saleProcess.execute(Arrays.asList(product1, product2, product3));
    }
}
