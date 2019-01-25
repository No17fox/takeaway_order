import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Tools tools = new Tools();
    List<Dish> menu = tools.loadMenu();
    tools.promptInput(menu);
    String userInput = tools.readUserInput();
    Map orderedDishes = tools.parseInput(userInput);
    System.out.println(orderedDishes);
  }
}
