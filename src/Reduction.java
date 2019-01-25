public class Reduction extends DiscountType {

  public Reduction() {
    super("满30减6");
  }

  @Override
  public double getDiscountPrice(Order order) {
    double discount = 0;
    if (order.originalPrice >= 30) {
      discount = 6;
    }
    return discount;
  }
}
