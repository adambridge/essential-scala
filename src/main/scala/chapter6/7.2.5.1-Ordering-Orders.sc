// Here is a case class to store orders of some arbitrary item.

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

// We have a requirement to order Orders in three different ways:
//
// by totalPrice;
// by number of units; and
// by unitPrice.
//
// Implement and package implicits to provide these orderings, and justify your packaging.

object TotalPriceOrdering {
  implicit val totalPriceOrdering: Ordering[Order] =
    Ordering.fromLessThan[Order](
      (o1, o2) =>
        o1.totalPrice < o2.totalPrice
    )
}

object UnitQuantityOrdering {
  implicit val unitQuantityOrdering: Ordering[Order] =
    Ordering.fromLessThan[Order](
      (o1, o2) =>
        o1.units < o2.units
    )
}

object UnitPriceOrdering {
  implicit val unitPriceOrdering: Ordering[Order] =
    Ordering.fromLessThan[Order](
      (o1, o2) =>
        o1.unitPrice < o2.unitPrice
    )
}

object TestTPO {
  import TotalPriceOrdering._
  val orders = List(Order(1, 0.9), Order(3, 0.5), Order(5, 0.1)).sorted
}

object TestUQO {
  import UnitQuantityOrdering._
  val orders = List(Order(1, 0.9), Order(3, 0.5), Order(5, 0.1)).sorted
}

object TestUPO {
  import UnitPriceOrdering._
  val orders = List(Order(1, 0.9), Order(3, 0.5), Order(5, 0.1)).sorted
}

TestUPO.orders
TestUQO.orders
TestTPO.orders
