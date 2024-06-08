class Rectangle(
                 height: Double,
                 width: Double
               ) extends Shape {
  override def sides: Int = 4
  override def perimeter: Double = 2 * height + 2 * width
  override def area: Double = height * width
}
