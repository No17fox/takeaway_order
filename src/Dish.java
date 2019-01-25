public class Dish {
  public final String id;
  public final String name;
  public final double price;
  public final boolean isDiscounted;

  public Dish(String id, String name, double price, boolean isDiscounted) {

    this.id = id;
    this.name = name;
    this.price = price;
    this.isDiscounted = isDiscounted;
  }
}
