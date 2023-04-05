package br.santosfyuri;

import java.math.BigDecimal;
import java.util.Arrays;

public class BoletoBancoBrasil implements Boleto {

    @Override
    public void send(String consumption, BigDecimal amount) {
        System.out.println("----------------------------------");
        System.out.println("Emissão da Guia de Pagamento do Banco do Brasil [PDF]");
        System.out.println("----------------------------------");
        Arrays.stream(consumption.split(",")).forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("Valor total: R$" + amount);
    }
}
