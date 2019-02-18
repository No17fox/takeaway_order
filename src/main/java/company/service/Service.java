package main.java.company.service;

import main.java.company.model.Dish;
import main.java.company.model.HalfPrice;
import main.java.company.model.Order;
import main.java.company.model.Reduction;
import main.java.company.tools.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public void orderDishes() {
        Tools tools = new Tools();
        List<Dish> menu = tools.loadMenu();

        this.promptInput(menu);
        String userInput = this.readUserInput();
        List<Dish> orderedDishes = this.parseInput(userInput, menu);

        Order order = new Order(orderedDishes);
        order.calcOriginalPrice();

        this.getBestCharge(order);
        tools.printOrder(order);
    }

    public void promptInput(List<Dish> menu) {
        System.out.println("欢迎进入--吃什么鸭--点餐系统\n\n今日菜单：");
        Tools tools = new Tools();
        tools.printMenu(menu);
        tools.printDiscountType(menu);
        System.out.println("\n请输入您需要的菜品和数量（例如：黄焖鸡 1，冰峰 1）：");
    }

    public String readUserInput() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Exception encountered: " + e);
            return null;
        }
    }

    public List<Dish> parseInput(String userInput, List<Dish> menu) {
        List<Dish> orderedDishesList = new ArrayList<Dish>();
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("请输入您需要的菜品和数量（例如：黄焖鸡 1，冰峰 1）：");
            userInput = readUserInput();
            orderedDishesList = parseInput(userInput, menu);
        } else {
            String[] inputArray = userInput.split(",|，");
            for (String item : inputArray) {
                String[] itemInfor = item.split(" ");
                if (itemInfor.length == 2 && !itemInfor[0].equals("") && itemInfor[1].matches("^\\d*$")) {
                    String dishName = itemInfor[0];
                    int dishCount = Integer.parseInt(itemInfor[1]);
                    Tools tools = new Tools();
                    Dish orderedDish = tools.getDishInfor(menu, dishName, dishCount);
                    if (orderedDish != null) {
                        orderedDishesList.add(orderedDish);
                    }
                } else {
                    System.out.println("输入格式有误，请重新输入您需要的菜品和数量（例如：黄焖鸡 1，冰峰 1）：");
                    userInput = readUserInput();
                    orderedDishesList = parseInput(userInput, menu);
                }
            }
        }
        System.out.println("\n下单成功！");
        return orderedDishesList;
    }

    public void getBestCharge(Order order) {
        Reduction reduction = new Reduction();
        HalfPrice halfPrice = new HalfPrice();
        double reductionResult = reduction.getDiscountPrice(order);
        double halfPriceResult = halfPrice.getDiscountPrice(order);
        if (reductionResult == 0 && halfPriceResult == 0) {
            order.setDiscountType("无可用优惠");
        } else if (reductionResult >= halfPriceResult) {
            order.setDiscountType(reduction.getType());
            order.setDiscount(reductionResult);
        } else {
            order.setDiscountType(halfPrice.getType());
            order.setDiscount(halfPriceResult);
            order.setHalfPriceDishes(halfPrice.getHalfPriceDishes());
        }
    }

}
