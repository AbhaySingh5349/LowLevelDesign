package DesignPatterns.ObserverDesignPattern;

import DesignPatterns.ObserverDesignPattern.observable.Observable;

public class NotificationSystem {
    private final Observable observable;

    public NotificationSystem(Observable observable) {
        this.observable = observable;
    }

    public void userRegistered(String name){
        String message = "User " + name + " is registered";
        observable.notifyObservers(message);
    }

    public void purchaseMade(String name, String item){
        String message = "User " + name + " purchased " + item;
        observable.notifyObservers(message);
    }
}
