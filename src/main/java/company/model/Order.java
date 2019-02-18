package main.java.company.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Dish> orderedDishes;
    private List<String> halfPriceDishes;
    private double discount;
    private String discountType;
    private double originalPrice;

    public Order(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
        this.originalPrice = 0;
        this.discountType = "";
        this.discount = 0;
        this.halfPriceDishes = new ArrayList<String>();
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void calcOriginalPrice() {
        for (Dish orderedDish : orderedDishes) {
            this.originalPrice += orderedDish.getPrice() * orderedDish.getCount();
        }
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<String> getHalfPriceDishes() {
        return this.halfPriceDishes;
    }

    public void setHalfPriceDishes(List<String> halfPriceDishes) {
        this.halfPriceDishes = halfPriceDishes;
    }

}
