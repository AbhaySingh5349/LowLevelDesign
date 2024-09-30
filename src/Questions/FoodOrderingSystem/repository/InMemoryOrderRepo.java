package Questions.FoodOrderingSystem.repository;

import Questions.FoodOrderingSystem.exceptions.OrderProcessingException;
import Questions.FoodOrderingSystem.model.Order;
import Questions.FoodOrderingSystem.model.Restaurant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryOrderRepo implements IOrderRepo{
    Map<String, List<Order>> currentOrders;
    Map<String, List<Order>> completedOrders;

    public InMemoryOrderRepo() {
        this.currentOrders = new HashMap<>();
        this.completedOrders = new HashMap<>();
    }

    @Override
    public void createOrder(Restaurant restaurant, Order order) {
        String restaurantId = restaurant.getId();
        Integer maxConcurrentCapacity = restaurant.getMAX_ORDER_CAPACITY();

        List<Order> orders = currentOrders.get(restaurantId);

        if(orders.size() == maxConcurrentCapacity){
            throw new OrderProcessingException("Restaurant is operating on max capacity, please wait!");
        }
        orders.add(order);
    }
}
