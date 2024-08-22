package ObserverDesignPattern;

import ObserverDesignPattern.observable.EventManagerObservable;
import ObserverDesignPattern.observable.InventoryObservable;
import ObserverDesignPattern.observable.SystemHealthObservable;
import ObserverDesignPattern.observer.*;

public class Main {
    public static void main(String[] args) {
        EventManagerObservable eventManagerObservable = new EventManagerObservable();
        eventManagerObservable.registerObserver(new EmailObserver());
        eventManagerObservable.registerObserver(new SmsObserver());
        eventManagerObservable.registerObserver(new PushObserver());

        NotificationSystem notificationSystem = new NotificationSystem(eventManagerObservable);

        notificationSystem.userRegistered("abhay");
        notificationSystem.purchaseMade("abhay", "laptop");

        System.out.println("**********************************************");

        SystemHealthObservable systemHealthObservable = new SystemHealthObservable();
        systemHealthObservable.registerObserver(new AdminAlertObserver());
        systemHealthObservable.registerObserver(new DashboardAlertObserver());

        systemHealthObservable.checkSystemHealth();

        System.out.println("**********************************************");

        InventoryObservable inventoryObservable = new InventoryObservable();
        inventoryObservable.registerObserver(new PushObserver());

        inventoryObservable.setStockCount(4);
    }
}
