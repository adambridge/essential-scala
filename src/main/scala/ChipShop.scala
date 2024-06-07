class ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, _, "Chips") => true
      case Cat(_, _, _) => false
    }
}
