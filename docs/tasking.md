# Tasking

- 工具类

  ```
  class Tools {
    promptInput()
    loadMenu()
    printMenu()
    readUserInput()
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
  ```

- 订单类

  ```
  class Order {
    dishes: Map<dish, count>
    originalPrice: double
    getOriginalPrice()
    getBestCharge()
    printOrder()
  }	
  ```

- 折扣类

  ```
  class DiscountType {
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
    getDiscountPrice(order)
  }
  ```

  