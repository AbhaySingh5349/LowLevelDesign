package DesignPatterns.ObserverDesignPattern;

import DesignPatterns.ObserverDesignPattern.observable.EventManagerObservable;
import DesignPatterns.ObserverDesignPattern.observable.InventoryObservable;
import DesignPatterns.ObserverDesignPattern.observable.SystemHealthObservable;
import DesignPatterns.ObserverDesignPattern.observer.*;

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
        inventoryObservable.registerObserver(new EmailObserver());

        inventoryObservable.setStockCount(4);
    }
}
