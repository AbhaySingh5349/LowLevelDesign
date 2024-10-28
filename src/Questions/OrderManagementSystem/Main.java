package Questions.OrderManagementSystem;

import Questions.OrderManagementSystem.model.Order;
import Questions.OrderManagementSystem.model.OrderItem;
import Questions.OrderManagementSystem.model.Product;
import Questions.OrderManagementSystem.repository.*;
import Questions.OrderManagementSystem.service.InventoryService;
import Questions.OrderManagementSystem.service.OrderService;
import Questions.OrderManagementSystem.service.ProductService;
import Questions.OrderManagementSystem.service.ReservationService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IProductRepo productRepo = new InMemoryProductRepo();
        ProductService productService = new ProductService(productRepo);
        Product p1 = new Product("1", "p1");
        Product p2 = new Product("2", "p2");
        Product p3 = new Product("3", "p3");

        productService.add(p1);
        productService.add(p2);
        productService.add(p3);

        IInventoryRepo inventoryRepo = new InMemoryInventoryRepo();
        InventoryService inventoryService = new InventoryService(inventoryRepo);
        inventoryService.add("1", 2);
        inventoryService.add("2", 5);
        inventoryService.add("3", 4);

        inventoryService.display();

        IReservationRepo reservationRepo = new InMemoryReservationRepo();
        ReservationService reservationService = new ReservationService(reservationRepo, inventoryService);

        IOrderRepo orderRepo = new InMemoryOrderRepo();
        OrderService orderService = new OrderService(orderRepo, reservationService, inventoryService);

        OrderItem item1 = new OrderItem("1", "1", 1);
        OrderItem item2 = new OrderItem("2", "2", 3);

        Order order = new Order("1", Arrays.asList(item1, item2));
        orderService.placeOrder(order);

        System.out.println("Order Status: " + order.getStatus());
        try {
            orderService.confirmOrder("1");
            System.out.println("Order Status: " + order.getStatus());
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Order Status: " + order.getStatus());
        inventoryService.display();
    }
}
