public class HalfPrice extends DiscountType {
  public HalfPrice() {
    super("指定菜品半价");
  }

  @Override
  public double getDiscountPrice(Order order) {
    double dicount = 0;
    for (OrderedDish orderedDish : order.orderedDishes) {
      if (orderedDish.isDiscounted) {
        dicount += orderedDish.price / 2;
      }
    }
    return dicount;
  }
}
