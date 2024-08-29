package DesignPatterns.ObserverDesignPattern.observable;

import DesignPatterns.ObserverDesignPattern.observer.Observer;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}
