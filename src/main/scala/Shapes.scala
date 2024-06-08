sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

final case class Circle(
                         radius: Double
                       ) extends Shape {
  override def sides: Int = 0
  override def perimeter: Double = 2 * math.Pi * radius
  override def area: Double = math.Pi * radius * radius
}

sealed trait Rectangular extends Shape {
  def height: Double
  def width: Double
  val sides: Int = 4
  override def perimeter: Double = 2 * height + 2 * width
  override def area: Double = height * width
}

final case class Rectangle(
                 height: Double,
                 width: Double
               ) extends Rectangular {
}

final case class Square(
              sideLength: Double
            ) extends Rectangular {
  val height: Double = sideLength
  val width: Double = sideLength
}

object Draw {
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius) => s"Behold, a Circle with a radius of $radius of your English centimeters!"
      case Rectangle(height, width) => s"This is my best $width by $height rectangle."
      case Square(sideLength) => s"What's the matter? You never seen a ${sideLength}cm square before?"
    }
}
