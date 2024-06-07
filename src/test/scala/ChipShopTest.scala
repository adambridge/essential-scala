import munit.FunSuite

class ChipShopTest extends FunSuite {
  val chipShop: ChipShop = ChipShop()
  val oswald: Cat = Cat("Oswald", "Black", "Milk")
  val henderson: Cat = Cat("Henderson", "Ginger", "Chips")
  val quentin: Cat = Cat("Quentin", "Tabby and white", "Curry")

  test("willServe") {
    assert(chipShop.willServe(henderson))
    assert(!chipShop.willServe(oswald))
  }
}
