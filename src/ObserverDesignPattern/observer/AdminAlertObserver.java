package ObserverDesignPattern.observer;

public class AdminAlertObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Admin Alert: " + message);
    }
}
