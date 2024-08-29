package DesignPatterns.ObserverDesignPattern.observer;

public class PushObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Sending push notification: " + message);
    }
}
