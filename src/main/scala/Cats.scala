trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline {
  override val sound: String = "roar"
}

case class Lion(
                 colour: String,
                 maneSize: Int
               ) extends BigCat

case class Tiger(
                  colour: String
                ) extends BigCat

case class Panther(
                    colour: String
                  ) extends BigCat

case class Cat(
                colour: String,
                food: String) extends Feline {
  val sound: String = "meow"
}

class ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, "Chips") => true
      case Cat(_, _) => false
    }
}
