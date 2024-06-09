sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def colour: Colour
}

final case class Circle(
                         radius: Double,
                         colour: Colour
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
                 width: Double,
                 colour: Colour
               ) extends Rectangular {
}

final case class Square(
              sideLength: Double,
              colour: Colour
            ) extends Rectangular {
  val height: Double = sideLength
  val width: Double = sideLength
}

object Draw {
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius, colour) => s"Behold, a $colour circle with a radius of $radius of your English centimeters!"
      case Rectangle(height, width, colour) => s"This is my best $colour $width by $height rectangle."
      case Square(sideLength, colour) => s"What's the matter? You never seen a $colour ${sideLength}cm square before?"
    }
}

sealed trait Colour {
  def red: Int
  def green: Int
  def blue: Int
  def toString: String
  def isLight: Boolean = red + green + blue > 250
}

case object Red extends Colour {
  val red = 255
  val green = 0
  val blue = 0
  override val toString = "red"
}

case object Yellow extends Colour {
  val red = 255
  val green = 255
  val blue = 0
  override val toString = "yellow"
}

case object Pink extends Colour {
  val red = 255
  val green = 125
  val blue = 255
  override val toString = "pink"
}

final case class CustomColour(
  red: Int,
  green: Int,
  blue: Int) extends Colour {
  override val toString: String =
    if (isLight) "light"
    else "dark"
}