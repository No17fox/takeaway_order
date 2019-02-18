package main.java.company.model;

public class Dish {
    private final String id;
    private final String name;
    private final double price;
    private final boolean isDiscounted;
    private int count;

    public Dish(String id, String name, double price, boolean isDiscounted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscounted = isDiscounted;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isDiscounted() {
        return this.isDiscounted;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
