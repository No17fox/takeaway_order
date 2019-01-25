import java.util.List;

public class Order {
  private final List<OrderedDish> orderedDishes;
  public double originalPrice;

  public Order(List<OrderedDish> orderedDishes) {
    this.orderedDishes = orderedDishes;
    this.originalPrice = 0;
  }

  public void calcOriginalPrice() {
    for (OrderedDish orderedDish : orderedDishes) {
      this.originalPrice += orderedDish.price * orderedDish.count;
    }
  }
}
