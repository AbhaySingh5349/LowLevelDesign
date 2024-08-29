package DesignPatterns.ObserverDesignPattern.observable;

import DesignPatterns.ObserverDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventManagerObservable implements Observable{
    private final List<Observer> observers;

    public EventManagerObservable() {
        this.observers = new ArrayList<>();
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
}
