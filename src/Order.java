import java.util.List;

public class Order {
  public final List<OrderedDish> orderedDishes;
  public double discount;
  public String discountType;
  public double originalPrice;

  public Order(List<OrderedDish> orderedDishes) {
    this.orderedDishes = orderedDishes;
    this.originalPrice = 0;
    this.discountType = "不使用满减优惠";
    this.discount = 0;
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
    if (reductionResult >= halfPriceResult && reductionResult != 0) {
      this.discountType = reduction.type;
      this.discount = reductionResult;
    } else {
      this.discountType = halfPrice.type;
      this.discount = halfPriceResult;
    }
  }
}
