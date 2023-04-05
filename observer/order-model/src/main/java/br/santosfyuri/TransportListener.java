package br.santosfyuri;

public class TransportListener implements Listener {
    private Notifier<Order> notifier;

    public TransportListener(Notifier<Order> notifier) {
        this.notifier = notifier;
        this.notifier.registerListener(this);
    }
    @Override
    public void update() {
        System.out.println("==================================================");
        System.out.println("Sending the products below to recipients:");
        for (Order order : this.notifier.getOrders()) {
            System.out.println(order.toString());
        }
    }
}
