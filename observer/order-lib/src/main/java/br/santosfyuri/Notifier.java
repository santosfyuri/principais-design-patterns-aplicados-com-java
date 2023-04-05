package br.santosfyuri;

import java.util.List;

public interface Notifier<T> {

    void registerListener(Listener listener);

    void removeListener(Listener listener);

    void notifyListeners();

    void setOrders(List<T> orders);

    List<T> getOrders();
}
