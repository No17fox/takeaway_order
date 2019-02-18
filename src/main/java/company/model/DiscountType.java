package main.java.company.model;

public abstract class DiscountType {
    private final String type;

    public DiscountType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public abstract double getDiscountPrice(Order order);
}
