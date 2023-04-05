package br.santosfyuri;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class StoreFactory implements SalesModuleFactory {

    private NFe nfe;
    private Boleto boleto;

    public StoreFactory() {

        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("/config.properties"));

            final String nfeClass = properties.getProperty("nfe");
            this.nfe = (NFe) Class.forName(nfeClass).getDeclaredConstructor().newInstance();

            final String boletoClass = properties.getProperty("boleto");
            this.boleto = (Boleto) Class.forName(boletoClass).getDeclaredConstructor().newInstance();


        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException |
                 NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public NFe createNFe() {
        return this.nfe;
    }

    @Override
    public Boleto createBoleto() {
        return this.boleto;
    }
}
