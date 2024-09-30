package Questions.FoodOrderingSystem.model;

import Questions.FoodOrderingSystem.enums.OrderStatus;

import java.util.List;

public class Order {
    private OrderStatus orderStatus;
    private List<MenuItem> menuItems;
    private User placedBy;

    public Double totalPrice(){
        return menuItems.stream().mapToDouble(item -> item.getPrice().getValue()).sum();
    }
}
