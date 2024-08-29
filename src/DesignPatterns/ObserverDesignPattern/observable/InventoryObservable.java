package DesignPatterns.ObserverDesignPattern.observable;

import DesignPatterns.ObserverDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class InventoryObservable implements Observable{
    private final List<Observer> observers;
    private Integer stockCount;

    public InventoryObservable() {
        this.observers = new ArrayList<>();
        this.stockCount = 0;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers){
            o.update(message);
        }
    }

    public void setStockCount(Integer newStock){
        stockCount += newStock;

        if(stockCount > 0){
            String message = "current stock qty: " + stockCount;
            notifyObservers(message);
        }
    }
}
