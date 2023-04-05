package br.santosfyuri;

public class InvoicingListener implements Listener {
    private Notifier<Order> notifier;

    public InvoicingListener(Notifier<Order> notifier) {
        this.notifier = notifier;
        this.notifier.registerListener(this);
    }

    @Override
    public void update() {
        System.out.println("==================================================");
        System.out.println("Invoicing requested for products:");
        for (Order order : this.notifier.getOrders()) {
            System.out.println(order.toString());
        }
    }
}
