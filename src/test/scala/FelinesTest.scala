import munit.FunSuite

class FelinesTest extends FunSuite {
  test("cat") {
    val cat = Cat("purple", "mushrooms")
    assertEquals(cat.food, "mushrooms")
    assertEquals(cat.sound, "meow")
  }
  test("lion") {
    val lion = Lion("Sandy", 7)
    assertEquals(lion.sound, "roar")
    assertEquals(lion.maneSize, 7)
  }
  test("tiger") {
    val tiger = Tiger("Stripy")
    assertEquals(tiger.sound, "roar")
  }
}
