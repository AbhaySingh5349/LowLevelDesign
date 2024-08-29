package DesignPatterns.ObserverDesignPattern.observer;

public class SmsObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Sending sms: " + message);
    }
}
