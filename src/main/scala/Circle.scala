case class Circle(
                   radius: Double
                 ) extends Shape {
  override def sides: Int = 0
  override def perimeter: Double = 2 * math.Pi * radius
  override def area: Double = math.Pi * radius * radius
}
