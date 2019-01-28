import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tools {

  public void promptInput(List<Dish> menu) {
    System.out.println("欢迎进入--吃什么鸭--点餐系统\n\n今日菜单：");
    printMenu(menu);
    printDiscountType(menu);
    System.out.println("\n请输入您需要的菜品和数量（例如：黄焖鸡 1，冰峰 1）：");
  }

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

  public List<OrderedDish> parseInput(String userInput, List<Dish> menu) {
    List<OrderedDish> orderedDishesList = new ArrayList<OrderedDish>();
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
          OrderedDish orderedDish = getOrderedDish(menu, dishName, dishCount);
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

  public OrderedDish getOrderedDish(List<Dish> menu, String dishName, int dishCount) {
    for (Dish dish : menu) {
      if (dish.getName().equals(dishName)) {
        return new OrderedDish(dish.getId(), dish.getName(), dish.getPrice(), dish.isDiscounted(), dishCount);
      }
    }
    return null;
  }

}
