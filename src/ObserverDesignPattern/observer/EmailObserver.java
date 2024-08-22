package ObserverDesignPattern.observer;

public class EmailObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Sending email: " + message);
    }
}
