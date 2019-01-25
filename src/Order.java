import java.util.ArrayList;
import java.util.List;

public class Order {
  public final List<OrderedDish> orderedDishes;
  private List<String> halfPriceDishes;
  public double discount;
  public String discountType;
  public double originalPrice;

  public Order(List<OrderedDish> orderedDishes) {
    this.orderedDishes = orderedDishes;
    this.originalPrice = 0;
    this.discountType = "";
    this.discount = 0;
    this.halfPriceDishes = new ArrayList<String>();
  }

  public void calcOriginalPrice() {
    for (OrderedDish orderedDish : orderedDishes) {
      this.originalPrice += orderedDish.price * orderedDish.count;
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
      this.discountType = reduction.type;
      this.discount = reductionResult;
    } else {
      this.discountType = halfPrice.type;
      this.discount = halfPriceResult;
      this.halfPriceDishes = halfPrice.halfPriceDishes;
    }
  }

  public void printOrder() {
    final String HEADER = "============= 订餐明细 =============";
    final String DIVIDING_LINE = "-----------------------------------";
    final String FOOTER = "===================================";
    System.out.println(HEADER);
    for (OrderedDish orderedDish : this.orderedDishes) {
      System.out.println(orderedDish.name + " x " + orderedDish.count + " = " + orderedDish.price * orderedDish.count + "元");
    }
    System.out.println(DIVIDING_LINE + "\n" + "使用优惠：");
    System.out.println(this.discountType + "(" + String.join("，", this.halfPriceDishes) + ")，省" + this.discount + "元");
    final double discountPrice = this.originalPrice - this.discount;
    System.out.println(DIVIDING_LINE + "\n总计：" + discountPrice + "元\n" + FOOTER);
  }
}
