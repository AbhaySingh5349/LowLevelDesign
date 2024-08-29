package DesignPatterns.ObserverDesignPattern.observable;

import DesignPatterns.ObserverDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class SystemHealthObservable implements Observable{
    private final List<Observer> observers;

    public SystemHealthObservable(){
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

    public void checkSystemHealth(){
        String message = "System Health Alert: CPU & Memory utilization is > 75%";
        notifyObservers(message);
    }
}
