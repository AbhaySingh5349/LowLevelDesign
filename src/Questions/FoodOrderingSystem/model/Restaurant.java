package Questions.FoodOrderingSystem.model;

import java.util.List;

public class Restaurant {
    private final String name;
    private final String id;
    private final String address;
    private final Rating rating;
    private final Menu menu;
    private final Integer MAX_ORDER_CAPACITY = 10;

    public Restaurant(String name, String id, String address, Rating rating, Menu menu) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.rating = rating;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Rating getRating() {
        return rating;
    }

    public Menu getMenu() {
        return menu;
    }

    public Integer getMAX_ORDER_CAPACITY() {
        return MAX_ORDER_CAPACITY;
    }
}
