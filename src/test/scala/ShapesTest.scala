import munit.FunSuite

class ShapesTest extends FunSuite {
  test("circle") {
    val circle = Circle(4, Yellow)
    assertEquals(circle.sides, 0)
    assertEquals(circle.perimeter, math.Pi * 2 * 4)
    assertEquals(circle.area, math.Pi * 4 * 4)
    assertEquals(Draw(circle),  "Behold, a yellow circle with a radius of 4.0 of your English centimeters!")
  }
  test("square") {
    val square = Square(1.2, Red)
    assertEquals(square.sides, 4)
    assertEquals(square.perimeter, 4.8)
    assertEquals(square.area, 1.44)
    assertEquals(Draw(square),  "What's the matter? You never seen a red 1.2cm square before?")
  }
  test("rectangle") {
    val rectangle = Rectangle(1.2, 2, Pink)
    assertEquals(rectangle.sides, 4)
    assertEquals(rectangle.perimeter, 6.4)
    assertEquals(rectangle.area, 2.4)
    assertEquals(Draw(rectangle), "This is my best pink 2.0 by 1.2 rectangle.")
  }
  test("colours") {
    val teal = CustomColour(40, 196, 134)
    assertEquals(s"$teal", "light")
    val purple = CustomColour(80, 17, 107)
    assertEquals(s"$purple", "dark")
  }
}
