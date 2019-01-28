import java.util.ArrayList;
import java.util.List;

public class Order {
  private final List<Dish> orderedDishes;
  private List<String> halfPriceDishes;
  private double discount;
  private String discountType;
  private double originalPrice;

  public Order(List<Dish> orderedDishes) {
    this.orderedDishes = orderedDishes;
    this.originalPrice = 0;
    this.discountType = "";
    this.discount = 0;
    this.halfPriceDishes = new ArrayList<String>();
  }

  public List<Dish> getOrderedDishes() {
    return orderedDishes;
  }

  public double getOriginalPrice() {
    return originalPrice;
  }

  public void calcOriginalPrice() {
    for (Dish orderedDish : orderedDishes) {
      this.originalPrice += orderedDish.getPrice() * orderedDish.getCount();
    }
  }

  public void getBestCharge() {
    Reduction reduction = new Reduction();
    HalfPrice halfPrice = new HalfPrice();
    double reductionResult = reduction.getDiscountPrice(this);
    double halfPriceResult = halfPrice.getDiscountPrice(this);
    if (reductionResult == 0 && halfPriceResult == 0) {
      this.discountType = "无可用优惠";
    } else if (reductionResult >= halfPriceResult) {
      this.discountType = reduction.getType();
      this.discount = reductionResult;
    } else {
      this.discountType = halfPrice.getType();
      this.discount = halfPriceResult;
      this.halfPriceDishes = halfPrice.getHalfPriceDishes();
    }
  }

  public void printOrder() {
    final String HEADER = "\n============= 订餐明细 =============";
    final String DIVIDING_LINE = "-----------------------------------";
    final String FOOTER = "===================================";
    System.out.println(HEADER);
    for (Dish orderedDish : this.orderedDishes) {
      System.out.println(orderedDish.getName() + " x " + orderedDish.getCount() + " = " + orderedDish.getPrice() * orderedDish.getCount() + "元");
    }
    System.out.println(DIVIDING_LINE + "\n使用优惠：");
    System.out.println(this.discountType + "(" + String.join("，", this.halfPriceDishes) + ")，省" + this.discount + "元");
    final double DISCOUNT_PRICE = this.originalPrice - this.discount;
    System.out.println(DIVIDING_LINE + "\n总计：" + DISCOUNT_PRICE + "元\n" + FOOTER);
  }
}
