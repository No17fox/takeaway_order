# Tasking

- 工具类

  ```
  class Tools {
    promptInput()
    loadMenu()
    printMenu()
    readUserInput()
    parseInput()
  }
  ```

- 菜品类

  ```
  class Dish {
    id: String
    name: String
    price: double
    isDiscounted: boolean
  }
  
  class OrderedDish extends Dish {
    id: String
    name: String
    price: double
    isDiscounted: boolean
    count: int
  }
  ```

- 订单类

  ```
  class Order {
    orderedDishes: [OrderedDish]
    originalPrice: double
    discountType: String
    discount: double
    halfPriceDishes: [String]
    calcOriginalPrice()
    getBestCharge()
    printOrder()
  }	
  ```

- 折扣类

  ```
  class abustract DiscountType {
    type: String
    getDiscountPrice(order)
  }
  
  //两类折扣类型
  class Reduction extends DiscountType {
    type: String
    getDiscountPrice(order)
  }
  
  class HalfPrice extends DiscountType {
    type: String
    halfPriceDishes: [String]
    getDiscountPrice(order)
  }
  ```

  