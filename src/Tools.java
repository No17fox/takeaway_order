import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tools {

  public void promptInput() {
    System.out.println("欢迎进入--吃什么鸭--点餐系统\n\n今日菜单：");
    printMenu();
    System.out.println("\n请输入您需要的菜品和数量（例如：黄焖鸡 x 1，冰峰 x 1）：");
  }

  public List<Dish> loadMenu() {
    List<Dish> menu = new ArrayList<Dish>();
    menu.add(new Dish("ITEM0001", "黄焖鸡", 18.00, true));
    menu.add(new Dish("ITEM0013", "肉夹馍", 6.00, false));
    menu.add(new Dish("ITEM0022", "凉皮", 8.00, true));
    menu.add(new Dish("ITEM0030", "冰锋", 2.00, false));
    return menu;
  }

  public void printMenu() {
    List<Dish> menu = loadMenu();
    for (Dish dish : menu) {
      System.out.println(dish.name + "--" + dish.price + "元");
    }
  }

  public void readUserInput() {
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    try {
      String userInput = bufferedReader.readLine();
    } catch (IOException e) {
      System.out.println("Exception encountered: " + e);
    }
  }

}
