package main.java.company.model;

public class Reduction extends DiscountType {

    public Reduction() {
        super("满30减6");
    }

    @Override
    public double getDiscountPrice(Order order) {
        double discount = 0;
        if (order.getOriginalPrice() >= 30) {
            discount = 6;
        }
        return discount;
    }
}
