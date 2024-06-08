import munit.FunSuite

class ShapesTest extends FunSuite {
  test("circle") {
    val circle = Circle(4)
    assertEquals(circle.sides, 0)
    assertEquals(circle.perimeter, math.Pi * 2 * 4)
    assertEquals(circle.area, math.Pi * 4 * 4)
  }
  test("square") {
    val square = Square(1.2)
    assertEquals(square.sides, 4)
    assertEquals(square.perimeter, 4.8)
    assertEquals(square.area, 1.44)
  }
  test("rectangle") {
    val rectangle = Rectangle(1.2, 2)
    assertEquals(rectangle.sides, 4)
    assertEquals(rectangle.perimeter, 6.4)
    assertEquals(rectangle.area, 2.4)
  }

}
