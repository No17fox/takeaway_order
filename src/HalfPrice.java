import java.util.ArrayList;
import java.util.List;

public class HalfPrice extends DiscountType {
  public List<String> halfPriceDishes;

  public HalfPrice() {
    super("指定菜品半价");
    this.halfPriceDishes = new ArrayList<String>();
  }

  @Override
  public double getDiscountPrice(Order order) {
    double dicount = 0;
    for (OrderedDish orderedDish : order.orderedDishes) {
      if (orderedDish.isDiscounted) {
        dicount += orderedDish.price / 2 * orderedDish.count;
        halfPriceDishes.add(orderedDish.name);
      }
    }
    return dicount;
  }
}
