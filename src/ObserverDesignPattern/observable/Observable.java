package ObserverDesignPattern.observable;

import ObserverDesignPattern.observer.Observer;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}
