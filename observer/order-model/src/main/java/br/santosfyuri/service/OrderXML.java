package br.santosfyuri.service;

import br.santosfyuri.Order;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.List;

public class OrderXML {

    private List<Order> orders;

    public List<Order> getFromXML(String fileName) {
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("orders", List.class);
        xstream.alias("order", Order.class);

        this.orders = (List<Order>) xstream.fromXML(this.getClass().getResource("/" + fileName));

        return this.orders;
    }
}
