package Questions.FoodOrderingSystem.repository;

import Questions.FoodOrderingSystem.model.Order;
import Questions.FoodOrderingSystem.model.Restaurant;

public interface IOrderRepo {
    void createOrder(Restaurant restaurant, Order order);
}
