package Questions.AmazonLockerService;

import Questions.AmazonLockerService.enums.Size;
import Questions.AmazonLockerService.model.*;
import Questions.AmazonLockerService.repository.InMemoryLockerRepository;
import Questions.AmazonLockerService.service.LockerService;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Initialize Repository
        InMemoryLockerRepository lockerRepository = new InMemoryLockerRepository();

        // Create Lockers
        Locker locker1 = new Locker("L1", Size.SMALL);
        Locker locker2 = new Locker("L2", Size.MEDIUM);
        Locker locker3 = new Locker("L3", Size.LARGE);
        Locker locker4 = new Locker("L4", Size.SMALL);
        Locker locker5 = new Locker("L5", Size.EXTRA_LARGE);

        // Add Lockers to Repository
        lockerRepository.addLockers(locker1, locker2, locker3, locker4, locker5);

        // Create Locker Location
        LockerLocation location = new LockerLocation("Loc1", LocalTime.of(8, 0), LocalTime.of(22, 0));
        location.addLocker(locker1);
        location.addLocker(locker2);
        location.addLocker(locker3);
        location.addLocker(locker4);
        location.addLocker(locker5);

        // Initialize Service
        LockerService lockerService = new LockerService(lockerRepository);

        // Create Customer
        Customer customer = new Customer("C1", "John Doe");

        // Create Items
        Item item1 = new Item("I1", "Book", 0.5);
        Item item2 = new Item("I2", "Laptop", 2.5);
        Item item3 = new Item("I3", "Headphones", 0.3);

        // Create Order
        Order order = new Order(Arrays.asList(item1, item2, item3));

        // Customer places an order
        customer.placeOrder(order, location, lockerService);

        // Simulate Customer picking up the order with the correct code
        System.out.println("\n--- Customer Pickup ---");
        customer.pickupOrder(order, lockerService, order.getLockerCode());

        // Attempt to pick up again (should fail)
        try {
            customer.pickupOrder(order, lockerService, order.getLockerCode());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Create a return order
        Order returnOrder = new Order(Arrays.asList(item1));
        customer.returnOrder(returnOrder, location, lockerService);

        // Simulate Customer picking up the returned order
        System.out.println("\n--- Customer Pickup Returned Order ---");
        customer.pickupOrder(returnOrder, lockerService, returnOrder.getLockerCode());

        // Display Locker States
        System.out.println("\n--- Locker States ---");
        for (Locker locker : location.getLockers()) {
            String state = locker.getState().isClosed() ? "Closed" : "Open";
            String pkgId = locker.getCurrentPackage() != null ? locker.getCurrentPackage().getPackageId() : "Empty";
            System.out.println("Locker " + locker.getLockerId() + " (" + locker.getSize() + ") - " + state + " - Package: " + pkgId);
        }
    }
}
