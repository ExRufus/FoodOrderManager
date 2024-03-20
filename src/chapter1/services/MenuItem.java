package chapter1.services;

public class MenuItem {
    private final String foodName;
    private final int foodPrice;

    public MenuItem(String name, int price) {
        foodName = name;
        foodPrice = price;
    }

    public String getName() {
        return foodName;
    }

    public int getPrice() {
        return foodPrice;
    }
}
