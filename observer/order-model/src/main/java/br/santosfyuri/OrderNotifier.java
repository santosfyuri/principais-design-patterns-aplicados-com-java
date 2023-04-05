package br.santosfyuri;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderNotifier implements Notifier<Order> {

    private Set<Listener> listeners;
    private List<Order> newOrders;

    public OrderNotifier() {
        this.listeners = new HashSet<>();
    }

    @Override
    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notifyListeners() {
        for (Listener listener : this.listeners) {
            listener.update();
        }
    }

    @Override
    public void setOrders(List<Order> orders) {
        this.newOrders = orders;
        this.notifyListeners();
    }

    @Override
    public List<Order> getOrders() {
        return this.newOrders;
    }
}
