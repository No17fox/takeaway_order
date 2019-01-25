public abstract class DiscountType {
  public final String type;

  public DiscountType(String type) {
    this.type = type;
  }

  public abstract double getDiscountPrice(Order order);
}
