import java.util.List;

public class Main {

  public static void main(String[] args) {
    Tools tools = new Tools();
    List<Dish> menu = tools.loadMenu();
    tools.promptInput(menu);
    String userInput = tools.readUserInput();
    List<OrderedDish> orderedDishes = tools.parseInput(userInput, menu);
    Order order = new Order(orderedDishes);
    order.calcOriginalPrice();
    order.getBestCharge();
    order.printOrder();
  }
}
