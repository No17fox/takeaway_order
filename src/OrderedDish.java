public class OrderedDish extends Dish{
  private final int count;

  public OrderedDish(String id, String name, double price, boolean isDiscounted, int count) {
    super(id, name, price, isDiscounted);
    this.count = count;
  }

  public int getCount() {
    return count;
  }
}
