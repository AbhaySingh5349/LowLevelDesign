package DesignPatterns.ObserverDesignPattern.observer;

public class DashboardAlertObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Dashboard Alert: " + message);
    }
}
