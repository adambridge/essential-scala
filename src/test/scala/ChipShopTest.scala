import munit.FunSuite

class ChipShopTest extends FunSuite {
  val chipShop: ChipShop = ChipShop()
  val oswald: Cat = Cat("Black", "Milk")
  val henderson: Cat = Cat("Ginger", "Chips")
  val quentin: Cat = Cat("Tabby and white", "Curry")

  test("willServe") {
    assert(chipShop.willServe(henderson))
    assert(!chipShop.willServe(oswald))
  }
}
