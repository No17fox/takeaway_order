package main.java.company.tools;

import main.java.company.model.Dish;
import main.java.company.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Tools {
    public List<Dish> loadMenu() {
        List<Dish> menu = new ArrayList<Dish>();
        menu.add(new Dish("ITEM0001", "黄焖鸡", 18.00, true));
        menu.add(new Dish("ITEM0013", "肉夹馍", 6.00, false));
        menu.add(new Dish("ITEM0022", "凉皮", 8.00, true));
        menu.add(new Dish("ITEM0030", "冰峰", 2.00, false));
        return menu;
    }

    public void printMenu(List<Dish> menu) {
        for (Dish dish : menu) {
            System.out.println(dish.getName() + "--" + dish.getPrice() + "元");
        }
    }

    public void printDiscountType(List<Dish> menu) {
        List<String> halfPriceDishes = new ArrayList<String>();
        for (Dish dish : menu) {
            if (dish.isDiscounted()) {
                halfPriceDishes.add(dish.getName());
            }
        }
        System.out.println("\n今日优惠活动：\n1. 满30减6\n2. " + String.join("、", halfPriceDishes) + "半价");
    }

    public Dish getDishInfor(List<Dish> menu, String dishName, int dishCount) {
        for (Dish dish : menu) {
            if (dish.getName().equals(dishName)) {
                Dish orderedDish = new Dish(dish.getId(), dish.getName(), dish.getPrice(), dish.isDiscounted());
                orderedDish.setCount(dishCount);
                return orderedDish;
            }
        }
        return null;
    }

    public void printOrder(Order order) {
        final String HEADER = "\n============= 订餐明细 =============";
        final String DIVIDING_LINE = "-----------------------------------";
        final String FOOTER = "===================================";
        System.out.println(HEADER);
        for (Dish orderedDish : order.getOrderedDishes()) {
            System.out.println(orderedDish.getName() + " x " + orderedDish.getCount() + " = " + orderedDish.getPrice() * orderedDish.getCount() + "元");
        }
        System.out.println(DIVIDING_LINE + "\n使用优惠：");
        System.out.println(order.getDiscountType() + "(" + String.join("，", order.getHalfPriceDishes()) + ")，省" + order.getDiscount() + "元");
        final double DISCOUNT_PRICE = order.getOriginalPrice() - order.getDiscount();
        System.out.println(DIVIDING_LINE + "\n总计：" + DISCOUNT_PRICE + "元\n" + FOOTER);
    }
}
