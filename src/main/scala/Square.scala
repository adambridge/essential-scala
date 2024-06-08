class Square(
              sideLength: Double
            ) extends Shape {
  override def sides: Int = 4
  override def perimeter: Double = 4 * sideLength
  override def area: Double = sideLength * sideLength
}
