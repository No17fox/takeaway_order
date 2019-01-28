import java.util.ArrayList;
import java.util.List;

public class HalfPrice extends DiscountType {
  private List<String> halfPriceDishes;

  public HalfPrice() {
    super("指定菜品半价");
    this.halfPriceDishes = new ArrayList<String>();
  }

  public List<String> getHalfPriceDishes() {
    return halfPriceDishes;
  }

  @Override
  public double getDiscountPrice(Order order) {
    double dicount = 0;
    for (Dish orderedDish : order.getOrderedDishes()) {
      if (orderedDish.isDiscounted()) {
        dicount += orderedDish.getPrice() / 2 * orderedDish.getCount();
        halfPriceDishes.add(orderedDish.getName());
      }
    }
    return dicount;
  }
}
