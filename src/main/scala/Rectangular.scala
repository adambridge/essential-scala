sealed trait Rectangular extends Shape {
  def height: Double
  def width: Double
  val sides: Int = 4
  override def perimeter: Double = 2 * height + 2 * width
  override def area: Double = height * width
}

case class Rectangle(
                 height: Double,
                 width: Double
               ) extends Rectangular {
}

case class Square(
              sideLength: Double
            ) extends Rectangular {
  val height: Double = sideLength
  val width: Double = sideLength
}
